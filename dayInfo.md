# Array
 - 用于构造数组的全局对象，数组是类似于列表的高阶对象。
 ```javascript 1.5
var promise = {
  'var'  : 'text',
  'array': [1, 2, 3, 4]
};

console.log(promise['var']);
```
# Array.prototype
 -  通过数组的原型对象可以为所有数组对象添加属性
 -  可以添加新方法和属性以扩展所有Array对象
 ```javascript 1.5
function Food(){}
Food.prototype.say = function(){
  console.log(this.color)
}
```
# Array.prototype.slice()
 - 抽取当前数组中的一段元素组合成一个新数组。
1. 从第 2 位开始删除 0 个元素，插入“drum”
```javascript 1.5
var myFish = ["angel", "clown", "mandarin", "sturgeon"];
var removed = myFish.splice(2, 0, "drum");

// 运算后的 myFish: ["angel", "clown", "drum", "mandarin", "sturgeon"]
// 被删除的元素: [], 没有元素被删除
```
2. 从第 3 位开始删除 1 个元素
```javascript 1.5
var myFish = ['angel', 'clown', 'drum', 'mandarin', 'sturgeon'];
var removed = myFish.splice(3, 1);

// 运算后的 myFish: ["angel", "clown", "drum", "sturgeon"]
// 被删除的元素: ["mandarin"]
```
3. 从第 0 位开始删除 2 个元素，插入"parrot"、"anemone"和"blue"
```javascript 1.5
var myFish = ['angel', 'clown', 'trumpet', 'sturgeon'];
var removed = myFish.splice(0, 2, 'parrot', 'anemone', 'blue');

// 运算后的 myFish: ["parrot", "anemone", "blue", "trumpet", "sturgeon"]
// 被删除的元素: ["angel", "clown"]
```
4. 从第 2 位开始删除所有元素
```javascript 1.5
var myFish = ['angel', 'clown', 'mandarin', 'sturgeon'];
var removed = myFish.splice(2);

// 运算后的 myFish: ["angel", "clown"]
// 被删除的元素: ["mandarin", "sturgeon"]
```
#call()
 方法使用一个指定的 this 值和单独给出的一个或多个参数来调用一个函数
 ```javascript 1.5
function Product(name, price) {
  this.name = name;
  this.price = price;
}

function Food(name, price) {
  Product.call(this, name, price);
  this.category = 'food';
}
var cheese = new Food('cheese', 5);
console.log(cheese)
//expected output :" Food?{name: "cheese", price: 5, category: "food"}"
console.log(new Food('cheese', 5).name);
// expected output: "cheese"
```
1. 使用 call 方法调用父构造函数
```javascript 1.5
function Product(name, price) {
     this.name = name;
     this.price = price;
   }
   
   function Food(name, price) {
     Product.call(this, name, price);
     this.category = 'food';
   }
   
   function Toy(name, price) {
     Product.call(this, name, price);
     this.category = 'toy';
   }
   
   var cheese = new Food('feta', 5);
   var fun = new Toy('robot', 40);
   console.log(cheese);
   console.log(fun);
   //expected output :  Food?{name: "feta", price: 5, category: "food"}
   //expected output :  Toy?{name: "robot", price: 40, category: "toy"}
```
2. 使用 call 方法调用函数并且指定上下文的 'this'
```javascript 1.5
function greet() {
  var reply = [this.animal, 'typically sleep between', this.sleepDuration].join(' ');
  console.log(reply);
}

var obj = {
  animal: 'cats', sleepDuration: '12 and 16 hours'
};

greet.call(obj); 
// expected output :   cats typically sleep between 12 and 16 hours
```   
3. 使用 call 方法调用函数并且不指定第一个参数（argument）
```javascript 1.5
var sData = 'Wisen';
function display() {
  console.log('sData value is %s ', this.sData);
}
display.call(); 
 // expected output :  sData value is Wisen
```
4. 注意：在严格模式下，this 的值将会是 undefined。见下文。
```javascript 1.5
'use strict';

var sData = 'Wisen';

function display() {
  console.log('sData value is %s ', this.sData);
}

display.call(); // Cannot read the property of 'sData' of undefined
```
# Array.prototype.slice.call()
 能把类数组对象转化成数组
```javascript 1.5
//类数组,有length属性，长度为2，第0个是lai，第1个是hua
var a={length:2,0:'lai',1:'hua'};
console.log(Array.prototype.slice.call(a,0));
// ["lai", "hua"],调用数组的slice(0);
```  