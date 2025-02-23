document.addEventListener("DOMContentLoaded", function() {
    loadExercises();
});

function addExercise() {
    const exercise = document.getElementById("exercise").value;
    const duration = document.getElementById("duration").value;
    if (exercise && duration) {
        const routine = { exercise, duration };
        let routines = JSON.parse(localStorage.getItem("routines")) || [];
        routines.push(routine);
        localStorage.setItem("routines", JSON.stringify(routines));
        loadExercises();
    }
}

function loadExercises() {
    const list = document.getElementById("exerciseList");
    list.innerHTML = "";
    let routines = JSON.parse(localStorage.getItem("routines")) || [];
    routines.forEach((routine, index) => {
        let li = document.createElement("li");
        li.textContent = `${routine.exercise} - ${routine.duration} mins`;
        list.appendChild(li);
    });
}
document.addEventListener("DOMContentLoaded", function() {
    loadExercises();
});

function addExercise() {
    const exercise = document.getElementById("exercise").value;
    const duration = document.getElementById("duration").value;
    if (exercise && duration) {
        const routine = { exercise, duration };
        let routines = JSON.parse(localStorage.getItem("routines")) || [];
        routines.push(routine);
        localStorage.setItem("routines", JSON.stringify(routines));
        loadExercises();
    }
}

function loadExercises() {
    const list = document.getElementById("exerciseList");
    list.innerHTML = "";
    let routines = JSON.parse(localStorage.getItem("routines")) || [];
    routines.forEach((routine, index) => {
        let li = document.createElement("li");
        li.textContent = `${routine.exercise} - ${routine.duration} mins`;
        li.draggable = true;
        li.ondragstart = (event) => {
            event.dataTransfer.setData("text", index);
        };
        li.ondrop = (event) => {
            event.preventDefault();
            let draggedIndex = event.dataTransfer.getData("text");
            let temp = routines[draggedIndex];
            routines[draggedIndex] = routines[index];
            routines[index] = temp;
            localStorage.setItem("routines", JSON.stringify(routines));
            loadExercises();
        };
        li.ondragover = (event) => event.preventDefault();
        list.appendChild(li);
    });
}
document.addEventListener("DOMContentLoaded", function () {
    // Get the canvas element
    let ctx = document.getElementById("progressChart").getContext("2d");

    // Sample Weekly Workout Data (Hours per Week)
    let progressData = {
        labels: ["Week 1", "Week 2", "Week 3", "Week 4", "Week 5", "Week 6", "Week 7"],
        datasets: [{
            label: "Workout Hours",
            data: [3, 5, 6, 4, 7, 8, 10], // Replace with actual progress data
            backgroundColor: "rgba(255, 235, 59, 0.6)", /* Yellow Bars */
            borderColor: "#ffeb3b",
            borderWidth: 2
        }]
    };

    // Create the Chart
    new Chart(ctx, {
        type: "bar",
        data: progressData,
        options: {
            responsive: true,
            maintainAspectRatio: false,
            scales: {
                y: {
                    beginAtZero: true
                }
            },
            animation: {
                duration: 2000, // 2s Animation
                easing: "easeInOutBounce"
            }
        }
    });
});
document.addEventListener("DOMContentLoaded", () => {
    const routineList = document.getElementById("routine-list");

    // Load saved routines from localStorage
    const savedRoutines = JSON.parse(localStorage.getItem("routines")) || [];

    if (savedRoutines.length === 0) {
        routineList.innerHTML = "<p>No routines found. Create one!</p>";
    } else {
        savedRoutines.forEach((routine, index) => {
            const li = document.createElement("li");
            li.innerHTML = `
                <strong>${routine.name}</strong>
                <p>Exercises: ${routine.exercises.length}</p>
                <button onclick="deleteRoutine(${index})">Delete</button>
            `;
            routineList.appendChild(li);
        });
    }
});

// Function to delete a routine
function deleteRoutine(index) {
    let savedRoutines = JSON.parse(localStorage.getItem("routines")) || [];
    savedRoutines.splice(index, 1);
    localStorage.setItem("routines", JSON.stringify(savedRoutines));
    location.reload(); // Refresh page to update list
}
document.addEventListener("DOMContentLoaded", () => {
    const routineList = document.getElementById("routine-list");

    // Sample Data (Replace with LocalStorage Data)
    let routines = [
        "🏋️ Morning Strength Training - 45 mins",
        "🏃 Evening Cardio - 30 mins",
        "🧘 Yoga & Meditation - 20 mins"
    ];

    function loadRoutines() {
        routineList.innerHTML = ""; // Clear list before reloading
        routines.forEach((routine, index) => {
            const li = document.createElement("li");
            li.innerHTML = `${routine} <button class="delete-btn" onclick="deleteRoutine(${index})">❌</button>`;
            routineList.appendChild(li);
        });
    }

    window.deleteRoutine = (index) => {
        routines.splice(index, 1); // Remove routine
        loadRoutines(); // Refresh list
    };

    loadRoutines(); // Initial Load
});
