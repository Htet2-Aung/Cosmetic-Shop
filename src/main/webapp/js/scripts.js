//let facewash = document.getElementById('facewash');
//let foundation = document.getElementById('foundation');
//let powder = document.getElementById('powder');
//let eyebrow = document.getElementById('eyebrow');
//let lipstick = document.getElementById('lipstick');
//let bodylotion = document.getElementById('body-lotion');

let qty = document.getElementById('qty');
let total = document.getElementById('total');
let order_price = document.getElementById('order_price');
qty.addEventListener('keyup',function(){
	total.value = qty.value * order_price.value;
});

//let product_qty = document.getElementById('product_qty');
//let shopping_qty = document.getElementById('shopping_qty');
//let add_item = document.getElementById('add_item');
//let cancel = document.getElementById('cancel');
//let product =0;
//product = product_qty.value;
//shopping_qty.text=product;
//add_item.addEventListener('mouseover',function(){
//	product = product - qty.value;
//});


