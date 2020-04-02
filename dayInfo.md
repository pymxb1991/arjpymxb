# Array
 - ���ڹ��������ȫ�ֶ����������������б�ĸ߽׶���
 ```javascript 1.5
var promise = {
  'var'  : 'text',
  'array': [1, 2, 3, 4]
};

console.log(promise['var']);
```
# Array.prototype
 -  ͨ�������ԭ�Ͷ������Ϊ������������������
 -  ��������·�������������չ����Array����
 ```javascript 1.5
function Food(){}
Food.prototype.say = function(){
  console.log(this.color)
}
```
# Array.prototype.slice()
 - ��ȡ��ǰ�����е�һ��Ԫ����ϳ�һ�������顣
1. �ӵ� 2 λ��ʼɾ�� 0 ��Ԫ�أ����롰drum��
```javascript 1.5
var myFish = ["angel", "clown", "mandarin", "sturgeon"];
var removed = myFish.splice(2, 0, "drum");

// ������ myFish: ["angel", "clown", "drum", "mandarin", "sturgeon"]
// ��ɾ����Ԫ��: [], û��Ԫ�ر�ɾ��
```
2. �ӵ� 3 λ��ʼɾ�� 1 ��Ԫ��
```javascript 1.5
var myFish = ['angel', 'clown', 'drum', 'mandarin', 'sturgeon'];
var removed = myFish.splice(3, 1);

// ������ myFish: ["angel", "clown", "drum", "sturgeon"]
// ��ɾ����Ԫ��: ["mandarin"]
```
3. �ӵ� 0 λ��ʼɾ�� 2 ��Ԫ�أ�����"parrot"��"anemone"��"blue"
```javascript 1.5
var myFish = ['angel', 'clown', 'trumpet', 'sturgeon'];
var removed = myFish.splice(0, 2, 'parrot', 'anemone', 'blue');

// ������ myFish: ["parrot", "anemone", "blue", "trumpet", "sturgeon"]
// ��ɾ����Ԫ��: ["angel", "clown"]
```
4. �ӵ� 2 λ��ʼɾ������Ԫ��
```javascript 1.5
var myFish = ['angel', 'clown', 'mandarin', 'sturgeon'];
var removed = myFish.splice(2);

// ������ myFish: ["angel", "clown"]
// ��ɾ����Ԫ��: ["mandarin", "sturgeon"]
```
#call()
 ����ʹ��һ��ָ���� this ֵ�͵���������һ����������������һ������
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
1. ʹ�� call �������ø����캯��
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
2. ʹ�� call �������ú�������ָ�������ĵ� 'this'
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
3. ʹ�� call �������ú������Ҳ�ָ����һ��������argument��
```javascript 1.5
var sData = 'Wisen';
function display() {
  console.log('sData value is %s ', this.sData);
}
display.call(); 
 // expected output :  sData value is Wisen
```
4. ע�⣺���ϸ�ģʽ�£�this ��ֵ������ undefined�������ġ�
```javascript 1.5
'use strict';

var sData = 'Wisen';

function display() {
  console.log('sData value is %s ', this.sData);
}

display.call(); // Cannot read the property of 'sData' of undefined
```
# Array.prototype.slice.call()
 �ܰ����������ת��������
```javascript 1.5
//������,��length���ԣ�����Ϊ2����0����lai����1����hua
var a={length:2,0:'lai',1:'hua'};
console.log(Array.prototype.slice.call(a,0));
// ["lai", "hua"],���������slice(0);
```  