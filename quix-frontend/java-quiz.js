let currentQuestionIndex = 0;
let questions = [];
let correctAnswers = 0; // Variable to track the number of correct answers
let totalQuestions = 0; // This will be set dynamically based on the API response
let timeLeft = 10; // Initial time for each question
let countdown; // Timer reference 

// Function to fetch questions from the API
async function fetchQuestions() {
    try {
        const response = await fetch('http://localhost:8080/quiz/java-questions'); // API URL
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        questions = await response.json(); // Assume API returns an array of question objects
        totalQuestions = questions.length; // Set totalQuestions based on fetched data
        document.getElementById('total-questions').textContent = totalQuestions; // Update the total questions in the HTML
        displayQuestion(); // Display the first question
        startTimer(); // Start the timer
    } catch (error) {
        console.error('Error fetching questions:', error);
        document.getElementById('question-text').textContent = "Failed to load questions. Please try again.";
    }
}

// Function to start the countdown timer
function startTimer() {
    timeLeft = 10; // Reset the timer for each question
    document.getElementById('timer').textContent = timeLeft;

    clearInterval(countdown); // Clear any existing timer
    countdown = setInterval(() => {
        timeLeft--;
        document.getElementById('timer').textContent = timeLeft;

        if (timeLeft < 0) {
            clearInterval(countdown);
            alert("Time's up! Moving to the next question.");
            nextQuestion(); // Automatically move to the next question
        }
    }, 1000);
}

function displayQuestion() {
    if (questions.length === 0) return;

    const questionText = document.getElementById('question-text');
    const optionsContainer = document.getElementById('options-container');
    const currentQuestion = questions[currentQuestionIndex];

    // Update this line to match the correct property
    questionText.textContent = currentQuestion.questionText;
    optionsContainer.innerHTML = ''; // Clear previous options

    currentQuestion.options.forEach(option => {
        const button = document.createElement('button');
        button.textContent = option;
        button.className = 'option';
        button.onclick = () => checkAnswer(option); // Call checkAnswer on click
        optionsContainer.appendChild(button);
    });

    document.getElementById('current-question').textContent = currentQuestionIndex + 1;
}

function checkAnswer(selectedOption) {
    const currentQuestion = questions[currentQuestionIndex];

    // Update this line to match the correct property
    if (selectedOption === currentQuestion.correctAnswer) {
        correctAnswers++; // Increment score if the answer is correct
    }

    // Move to the next question
    nextQuestion();
}

function nextQuestion() {
    clearInterval(countdown); // Stop the current timer
    if (currentQuestionIndex < questions.length - 1) {
        currentQuestionIndex++;
        displayQuestion(); // Display the next question
        startTimer(); // Restart the timer
    } else {
        // Quiz Completed: Save score and redirect to results page
        localStorage.setItem('quizScore', correctAnswers); // Save the score
        localStorage.setItem('totalQuestions', totalQuestions); // Save total questions
        window.location.href = 'result.html'; // Redirect to results page
    }
}

window.onload = fetchQuestions;
