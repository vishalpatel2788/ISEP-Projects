function validate(){
alert ( "Thank you for your Feedback...!!" );
return true;
}

	
mybutton = document.getElementById("myBtn");
// When the user scrolls down 100px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};
function scrollFunction() {
if (document.body.scrollTop > 100 || document.documentElement.scrollTop > 100) {
mybutton.style.display = "block";
} else {
mybutton.style.display = "none";
}
}
// When the user clicks on the button, scroll to the top of the document
function topFunction() {
document.body.scrollTop = 0; // For Safari
document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
}
//************ top arrow script ***************

mybutton = document.getElementById("myBtn");
// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};
function scrollFunction() {
if (document.body.scrollTop > 100 || document.documentElement.scrollTop > 100) {
mybutton.style.display = "block";
} else {
mybutton.style.display = "none";
}
}
// When the user clicks on the button, scroll to the top of the document
function topFunction() {
document.body.scrollTop = 0; // For Safari
document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
}



let options = {
        numberPerPage:10, 
        goBar:true, 
        pageCounter:true, 
    };

    let filterOptions = {
        el:'#searchBox' 
    };

    paginate.init('.myTable',options,filterOptions);

    


    function fetch() {
        $.get("https://api.covid19india.org/data.json",
            function (data) {
                console.log(data['statewise'].length)  //total countries
                var tbl = document.getElementById('tbl');
                for(var i=1;i<(data['statewise'].length);i++)
                {
                    var x = tbl.insertRow(i);
                    x.insertCell(0);
                    tbl.rows[i].cells[0].innerHTML = data['statewise'][i-1]['lastupdatedtime'];

                    x.insertCell(1);
                    tbl.rows[i].cells[1].innerHTML = data['statewise'][i-1]['state'];

                    x.insertCell(2);
                    tbl.rows[i].cells[2].innerHTML = data['statewise'][i-1]['confirmed'];

                    x.insertCell(3);
                    tbl.rows[i].cells[3].innerHTML = data['statewise'][i-1]['active'];
     
                    x.insertCell(4);
                    tbl.rows[i].cells[4].innerHTML = data['statewise'][i-1]['recovered'];

                    x.insertCell(5);
                    tbl.rows[i].cells[5].innerHTML = data['statewise'][i-1]['deaths'];

                }
            });
    }
