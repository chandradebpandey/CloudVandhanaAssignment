// Clears the screen on click of AC button.
function clearScreen() {
    document.getElementById("result").value = "";
  }
  // Displays entered value on screen.
  function liveScreen(value) {
    document.getElementById("result").value += value;
  }

//   function switchTheme() {
//     let darkMode = document.getElementById("dark-mode");
//     let theme = document.getElementById("theme");
//     if (theme.getAttribute("href") == "light.css") {
//       theme.href = "dark.css";
//       darkMode.innerHTML = "Light Mode 🌞";
//     } else {
//       theme.href = "light.css";
//       darkMode.innerHTML = "Dark Mode 🌙";
//     }
  //}