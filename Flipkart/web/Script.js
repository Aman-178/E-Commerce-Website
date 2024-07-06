/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

//Login button
const loginButton = document.querySelector('.login');

console.log(loginButton);
const hiddenButtonList =loginButton.querySelector('.hidden-button-list');
const angleDownIcon = document.querySelector('.fa-angle-down');

 loginButton.addEventListener('mouseenter', function() {
     hiddenButtonList.style.display = 'block';
     angleDownIcon.style.transform = 'rotate(180deg)'; 
     angleDownIcon.style.transition = 'transform 0.5s ease-in-out';
  });

 loginButton.addEventListener('mouseleave', function() {
    hiddenButtonList.style.display = 'none';
    angleDownIcon.style.transform = 'rotate(0deg)';
 });
 

//vertical line
const vertical = document.querySelector('.vertical');
const hiddenList = vertical.querySelector('.hidden-list');

// Show the list when mouse enters 'vertical'
vertical.addEventListener('mouseenter', function() {
  
   hiddenList.style.display = 'block';
});

// Hide the list when mouse leaves 'vertical'
vertical.addEventListener('mouseleave', function() {
    
        hiddenList.style.display = 'none';
        console.log("Executing hide action");
  
});


//Add eventListner on Faishon
// Selecting elements
const fashionDiv = document.querySelector('.fashion');
const hiddenListFashion = fashionDiv.querySelector('.fashion-hidden-list');
const Firstlist=document.querySelector('#mensTopList');
//console.log(Firstlist);
const fashionIcon = document.querySelector('#faishondown');
const fashionP = fashionDiv.querySelector('.fashion-p');
const mensIcon = document.querySelector('#mens-icon');
const mensHiddenList = hiddenListFashion.querySelector('.mens-hidden-list');
const firstHiddenList = hiddenListFashion.querySelector('#mensTopList');

// Adding mouseenter event listener to fashionDiv
fashionDiv.addEventListener('mouseenter', function() {
    
    hiddenListFashion.style.display = 'block';
    fashionIcon.style.transform = 'rotate(180deg)';
    fashionP.style.color = 'blue';
    mensIcon.style.fontweight='bold';
    if(firstHiddenList){
        firstHiddenList.style.fontStyle = 'bolder';
        firstHiddenList.style.fontSize = 'large';
    }
    if (mensHiddenList) {
        mensHiddenList.style.display = 'block';
    }
});

    fashionDiv.addEventListener('mouseleave', function() {
        hiddenListFashion.style.display = 'none';
        fashionIcon.style.transform = 'rotate(0deg)';
        fashionP.style.color='black';
    });

  fashionP.addEventListener('mouseenter', function() {
        hiddenListFashion.style.display = 'block';
        fashionIcon.style.transform = 'rotate(180deg)';
        fashionIcon.style.transition = 'transform 0.5s ease-in-out';
        fashionP.style.color='blue';
       
    });

fashionP.addEventListener('mouseleave', function() {
        hiddenListFashion.style.display = 'none';
        fashionIcon.style.transform = 'rotate(0deg)';
        fashionP.style.color='black';
    });


//for second mens top
    const secondListElement = document.querySelector('#secondlist');
//    console.log(secondListElement); // Check if it's not null
    // Further code involving Secondlist goes here


const menstoplist1=document.querySelector('.mens-hidden-list1');
//console.log(menstoplist1);
const topicon=document.querySelector('#mens-icon1');
 
       
   secondListElement.addEventListener('mouseenter',function(){
       topicon.style.display='block';
       menstoplist1.style.display='block';
       if (mensHiddenList) {
        mensHiddenList.style.display = 'none';
    }
    mensIcon.style.display='none';
   });
       
        
  
  Firstlist.addEventListener('mouseenter',function(){
       topicon.style.display='none';
       menstoplist1.style.display='none';
       if (mensHiddenList) {
        mensHiddenList.style.display = 'block';
    }
    mensIcon.style.display='block';
   });










//imagecontainer for.
// Array of image URLs
const imageUrls = [
    'https://rukminim2.flixcart.com/fk-p-flap/1000/170/image/bf42fbdd3d37c8c3.jpg?q=20',
    'https://rukminim2.flixcart.com/fk-p-flap/1000/170/image/bf42fbdd3d37c8c3.jpg?q=20',
    'fgfdgdfg.webp',
    'cloud.webp'
    
    
];

// Get the image container element
const imageContainer = document.getElementById('imageContainer');



function displayImages() {
    let index = 0;

    function displayNextImage() {
        const imageUrl = imageUrls[index];
        
        // Create an image element
        const img = document.createElement('img');
        img.src = imageUrl;
        img.alt = `Image ${index + 1}`; 
        img.onload = () => {
            img.style.display = 'block'; // Show the image when loaded
        };
        // Append the image to the container
        imageContainer.innerHTML = ''; // Clear previous images
        imageContainer.appendChild(img);

      
        const delay = 1000; 

        // Move to the next image index, wrapping around at the end
        index = (index + 1) % imageUrls.length;

       
        setTimeout(displayNextImage, delay);
    }

   
    displayNextImage();
}


displayImages();


//Add Filter action.
const FilterButton = document.querySelector('#Filter');
const FilterList = document.querySelector('.Filter-List');

FilterButton.addEventListener('mouseenter', function() {
    FilterList.style.display = 'block';
});

FilterButton.addEventListener('mouseleave', function() {
    FilterList.style.display = 'none';
});

const LaptopBrand=document.querySelector('.LaptopBrand');
const MobileBrand=document.querySelector('.MobileBrand');
const Prices=document.querySelector('.Prices');
const Laptoplist=document.querySelector('.Laptoplist');
const Mobilelist=document.querySelector('.Mobilelist');
const Pricelist=document.querySelector('.Pricelist');
LaptopBrand.addEventListener('mouseenter', function () {
    displayList('Laptoplist');
});

MobileBrand.addEventListener('mouseenter', function () {
    displayList('Mobilelist');
});

Prices.addEventListener('mouseenter', function () {
    displayList('Pricelist');
});

function displayList(category) {
    // Hide all lists first
    Laptoplist.style.display = 'none';
    Mobilelist.style.display = 'none';
    Pricelist.style.display = 'none';

    // Show the selected list
    if (category === 'Laptoplist') {
        Laptoplist.style.display = 'block';
    } else if (category === 'Mobilelist') {
        Mobilelist.style.display = 'block';
    } else if (category === 'Pricelist') {
        Pricelist.style.display = 'block';
    }
}


    
// Function to collect selected items in a list
function collectSelectedItems(list) {
    return Array.from(list.querySelectorAll('input[type="checkbox"]:checked')).map(checkbox => checkbox.value);

}





//
//         Make API call with selected filters
//   
//    







const Spinner=document.querySelector('.loader');
//Api Fetched here
const container=document.getElementById("products-container");
      container.innerHTML='';
var Addvalue=document.querySelector('#Addvalue');
var currentValue = parseInt(Addvalue.innerHTML);
const totalprices=document.createElement('p');


const checkoutdata=document.getElementById('checkoutdata');
checkoutdata.innerHTML='';
console.log(checkoutdata);
const checoutbutton=document.querySelector('.checoutbutton');
console.log(checoutbutton);
let itemprice=0;
const FinalCheckout = document.querySelector('.Final-Checkout');
function search() {
    // Get the value from the search input field
    var searchTerm = document.querySelector('.search').value.trim();
    
    // Log the search term to the console for verification
    console.log('Search term entered:', searchTerm);
    container.innerHTML = '';

    
FetchData(searchTerm);

}

document.querySelectorAll('.Filter-List input[type="checkbox"]').forEach(function(checkbox){
    checkbox.addEventListener('change',function(){
       // Get selected filters from all lists
        const selectedLaptops  = collectSelectedItems(Laptoplist);
        const selectedMobiles  = collectSelectedItems(Mobilelist);
        const selectedPrices   = collectSelectedItems(Pricelist);

        // Example: Log selected filters
        console.log('Selected Laptops:', selectedLaptops);
        console.log('Selected Mobiles:', selectedMobiles);
        console.log('Selected Prices:', selectedPrices);
        
        console.log(selectedLaptops.length);
       
        
       container.innerHTML='';
        FetchData(" ",selectedLaptops,selectedMobiles,selectedPrices);
        
    });
});


async function FetchData(searchTerm='',selectedLaptops=[],selectedMobiles=[],selectedPrices=[]){
    Spinner.style.display='block';
    try{
          console.log('length of:',selectedLaptops.length);
          console.log('searchterm:',searchTerm);
        const urlParams = new URLSearchParams();

          if (searchTerm!==' ') {
            urlParams.append('searchTerm', searchTerm);
        }

        if (selectedLaptops.length > 0) {
            selectedLaptops.forEach(laptop => urlParams.append('Laptops', laptop));
        }
        if (selectedMobiles.length > 0) {
            selectedMobiles.forEach(mobile => urlParams.append('Mobiles', mobile));
        }
        if (selectedPrices.length > 0) {
            selectedPrices.forEach(price => urlParams.append('Prices', price));
        }

        const url = urlParams.toString() ? `FetchData?${urlParams.toString()}` : 'FetchData';
        console.log(url);

        const response=await fetch(url);
        if(!response.ok){
            console.log("Error in fetcvhing");
        }else{
            const data= await response.json();
            console.log(data);
            
           
      data.forEach(product => {
        
        const productDiv = document.createElement("div");
        productDiv.classList.add("productItem");
        
        
        const productImage = document.createElement("img");
        
        productImage.src = product.ProductImage;
        productImage.alt = "Sorry";
        productImage.style.height="90px";
        productImage.style.width="100%";
        
        const productName = document.createElement("h5");
        productName.textContent = product.ProductName;
        
        const productPrice = document.createElement("price");
        productPrice.textContent = `Rs.${product.ProductPrice}`;
        
        const productDescription = document.createElement("p");
        productDescription.textContent =  product.ProductDescription;
        
         const Addcartbutton=document.createElement('button');
         Addcartbutton.textContent="Add To Cart";
         Addcartbutton.classList.add("Addcatbutton");
        
        
        // Append elements to productDiv
        productDiv.appendChild(productImage);
        productDiv.appendChild(productName);
        productDiv.appendChild(productPrice);
        productDiv.appendChild(productDescription);
        productDiv.appendChild(Addcartbutton);
        
        
        // Append productDiv to productsContainer
        container.appendChild(productDiv);
        
       
     

       //Add eventListener on Add to Cart button
       
       Addcartbutton.addEventListener('click',function(){
           console.log("button clicked");
           var newvalue=++currentValue;
           Addvalue.innerHTML=newvalue;
           Addvalue.style.color='green';
           Addvalue.style.fontStyle='large';
           Addvalue.style.fontWeight='bolder';

           
          
           //checkout logic
           
           
           const checkout=document.createElement('div');
           checkout.classList.add("cherckoutitem");
           const Removecartbutton=document.createElement('button');
           const Buytbutton=document.createElement('button');
           Removecartbutton.classList.add('buttonremove');
           Buytbutton.classList.add('buttonremove');
           Removecartbutton.textContent='Remove Item';
           Buytbutton.textContent='Buy';
           
           checkout.innerHTML=`
            <img src='${product.ProductImage}' height='100px' width='80px'>
             <h4>${product.ProductName}<\h4>
           <h5>RS.${product.ProductPrice}<\h5>`;

           checkout.appendChild(Removecartbutton);
            checkout.appendChild(Buytbutton);
//             checkout.appendChild(productPrice);
           checkoutdata.appendChild(checkout);
           
          
           //Add Eventlistener on remove item;
           // Display accumulated itemprice in Final-Checkout element
            

                Removecartbutton.addEventListener('click', function() {
                    var newvalue = --currentValue;
                    Addvalue.innerHTML = newvalue;
                    checkoutdata.removeChild(checkout);

                    // Subtract product price from itemprice
                    itemprice -= parseFloat(product.ProductPrice);

                    // Update FinalCheckout with the updated itemprice
                    FinalCheckout.textContent = `Total: Rs.${itemprice}`;

                    // Hide FinalCheckout if itemprice is zero or less
                    if (itemprice <= 0) {
                        FinalCheckout.style.display = 'none';
                         checoutbutton.style.display='none';
                         suceess.style.display='none';
                    }
                });

                Buytbutton.addEventListener('click', function() {
                    // Accumulate product price to itemprice
                    itemprice += parseFloat(product.ProductPrice);

                    // Update FinalCheckout with the updated itemprice
                     FinalCheckout.textContent = `Total: Rs.${itemprice}`;
                     FinalCheckout.style.display = 'block';
                     checoutbutton.style.display='block';
                });

                

             
       });
       
       
       
       
       
       
            });
        }
       }catch(error){
        console.log("error in fetching Api");
    }
    Spinner.style.display='none';
}


FetchData();








    
 
      
//cart function implements.
const cart=document.getElementsByClassName('cart');

console.log(cart);
const itemcheckoutcontainer=document.getElementById('checkout-container');
const buttons =document.querySelector('.cart button');
console.log(itemcheckoutcontainer);
buttons.addEventListener('click' , function(){
   setTimeout(()=>{
        itemcheckoutcontainer.style.display='block';
         itemcheckoutcontainer.style.transitionduration= '3s';
   },2000);
});

const suceess=document.querySelector('.sucess');
//checoutbutton.addEventListener('click' ,function(){
//    checoutbutton.style.display='block';
//    
//    const sc=document.createElement('span');
//    sc.textContent='Successfully ordered';
//    suceess.appendChild(sc);
//    FinalCheckout.style.display='none';
//});



checoutbutton.addEventListener('click', function() {
  
  checkStatus();
}); 


async function checkStatus(){
      const url='LoginStatusServlet';
     try{
        const response=await fetch(url);
      if(!response.ok){
          console.log("Not Working Api");
          
      }else{
          const data=await response.text();
          console.log(data);
          if(data.trim()!=='loggedIn'){
              alert('Please login to Proceed');
              window.location.href='Login.html';
          }else{
              alert('Proceed To Checkout');
              
          }
      }
     }catch(Error){
         console.log("errror in fetching");
     }
      
  }
  
