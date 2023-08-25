const btn1 = document.querySelector(".btn1");
const btn2 = document.querySelector(".btn2");


const contents =document.querySelectorAll(".content");
btn1.addEventListener("click", () =>{
    // contents[0].classList.remove('hide');
    // or
    contents[1].style.display = "none";
    contents[0].style.display = "block";
})

btn2.addEventListener("click", () =>{
    // contents[1].classList.remove('hide');
    // or
    contents[0].style.display = "none";
    contents[1].style.display = "block";
})


// btn2.addEventListener("click", () =>{
//     console.log("click btn2");
// })



// function click(){
// }


// btn1.addEventListener("click", click);
// btn2.addEventListener("click", click);


var j =0;
var k =0;
console.log(j, k);

j= 3;
console.log(j);

k = 5;
console.log(k);

// var -> let, const


// let j =0;
// const k =0;
// console.log(j, k);

// k = 5;
// j= 3;

// console.log(j, k);