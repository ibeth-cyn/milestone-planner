// Get the modal
var add_modal = document.getElementById("modal_addMilestoneBlock");

// Get the button that opens the modal
var add_btn = document.getElementById("addMilestone_button");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close_addMilestone")[0];

// When the user clicks on the button, open the modal
add_btn.onclick = function() {
    add_modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    add_modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        add_modal.style.display = "none";
    }
}