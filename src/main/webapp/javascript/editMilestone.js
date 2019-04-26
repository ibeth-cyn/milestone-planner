// Get the modal
var edit_modal = document.getElementsByClassName("modal_editMilestoneBlock");

// Get the button that opens the modal
var edit_btn = document.getElementsByClassName("editMilestone_button");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close_editMilestone")[0];

// When the user clicks on the button, open the modal

for(var i =0; i<edit_btn.length; i++){
    edit_btn[i].addEventListener("click", showModal);
}

function showModal(event){
    var btnId = event.target.id;
    var rowId = btnId.split("-")[1];
    var rowData = document.getElementById('modal_editMilestoneBlock-'+rowId);

    rowData.style.display = 'block';
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    edit_modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == edit_modal) {
        edit_modal.style.display = "none";
    }
}