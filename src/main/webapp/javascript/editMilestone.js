// Get the modal
var edit_modal = document.getElementById("modal_editMilestoneBlock");

// Get the button that opens the modal
var edit_btn = document.getElementById("editMilestone_button");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close_editMilestone")[0];

// When the user clicks on the button, open the modal
edit_btn.onclick = function() {
    edit_modal.style.display = "block";

    // $.ajax({
    //     url:"/webApp.listMilestone.do",
    //     dataType:"html",
    //     success:function(milestone){
    //         var data="";
    //         for(i=0;i<milestone.length;i++){
    //             var p=JSON.parse(milestone[i]);
    //             data+="<tr><td>"+p.description+"</td></tr>";
    //         }
    //         $('#content').html(data);
    //     },
    //     error:function() {
    //         alert("error occurred");
    //     }
    //});


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