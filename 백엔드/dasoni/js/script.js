const f1 = document.querySelector(".f1");
const p = f1.querySelectorAll("p");
const span = f1.querySelector("span");
f1.addEventListener("click", () => {
  console.log("box click");
  p[0].style.opacity = "1";
  p[1].style.opacity = "1";
  span.style.opacity = "1";
  p[0].style.marginTop = "0";
  p[1].style.marginTop = "0";
  span.style.marginTop = "0";
});
