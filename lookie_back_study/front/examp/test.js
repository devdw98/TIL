// var el = document.querySelector(".outside");

// el.addEventListener("click", function(e){
//     // console.log("clicked!",e);
//     var target = e.target;
//     console.log(target.className, target.nodeName);
// });

var oReq = new XMLHttpRequest();
oReq.addEventListener("load", function(){
    console.log(this.responseText);
});

oReq.open("GET","./json.txt");
oReq.send();