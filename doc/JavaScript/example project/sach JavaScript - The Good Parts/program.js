// Object Literals
var stooge = {
	"first-name" : "Jerome",
	"last-name" : "Howard"
}

stooge.nickname = 'Cursly';
// Prototype
if (typeof Object.create !== 'function'){
	Object.create = function(o){
		var F = function(){};
		F.prototype = o;
		return new F();
	};
}
var another_stooge = Object.create(stooge);
another_stooge['first-name'] = 'Harry';
another_stooge['middle-name'] = 'Moses';
another_stooge.nickname = 'Moe';

stooge.profession = 'actor';
document.writeln(another_stooge.profession);

// Enumeration
var name;
for (name in another_stooge) {
	if (typeof another_stooge[name] !== 'function') {
		document.writeln(name + ':' + another_stooge[name]);
	}
}

// Delete
delete another_stooge.nickname;
document.writeln('<h3>Delete</h3>');
document.writeln(another_stooge.nickname);

// Function Literal
document.writeln('<h3>Function Literal</h3>');
var add = function (a,b){
	return a+b;
}

var sum = add(3, 4);
document.writeln("sum = " + sum);

// Function Literal
document.writeln('<h3>The Apply Invocation Pattern</h3>');
var array = [3,4];
var sum2 = add.apply(null, array);
document.writeln(sum2);

// Augmenting types
Function.prototype.method = function(name, func){
	this.prototype[name] = func;
	return this;
}

Number.method('integer', function () {
	return Math[this < 0 ? 'ceil' : 'floor'](this);
});
document.writeln((-10 / 3).integer()); // -3
document.writeln('"'+"neat".trim()+'"');

// Closure
document.writeln('<h3>Closure</h3>');
var myObject = function(){
	var value = 0;

	return {
		increment: function (inc){
			value += typeof inc === 'number' ? inc : 1;
		},
		getValue: function(){
			return value;
		}
	};
}();
function volume( l, w, h ) {
  return l * w * h;
}

var curried = curry( volume );

curried( 1 )( 2 )( 3 );
document.writeln('Hello, \u0045, world!');
