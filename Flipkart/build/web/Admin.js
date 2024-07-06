/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

const Button1=document.querySelector('.button1');
const Button2=document.querySelector('.button2');
const Button3=document.querySelector('.button3');
const Button4=document.querySelector('.button4');

//get  product

const AddProduct=document.querySelector('.AddForm');
const UpdateProduct=document.querySelector('.UpdateForm');

Button1.addEventListener('click',function(){
    AddProduct.style.display='block';
    UpdateProduct.style.display='none';
});

Button2.addEventListener('click',function(){
    AddProduct.style.display='none';
    UpdateProduct.style.display='none';
});

Button3.addEventListener('click',function(){
    AddProduct.style.display='none';
    UpdateProduct.style.display='block';
});


//Button4.addEventListener('click',function(){
//    AddProduct.style.display='none';
//    UpdateProduct.style.display='none';
//});











