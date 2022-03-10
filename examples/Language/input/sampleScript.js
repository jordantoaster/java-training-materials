	function printEmployee() {
		var msg = "Empoyee called ";
		msg += this.name;
		msg += " working in ";
		msg += this.dept;
		msg += " earning ";
		msg += this.salary;
		msg += "\n";
		return msg;
	}
	function Employee(p1,p2,p3) {
		this.name = p1;
		this.dept = p2;
		this.salary = p3;
		this.toString = printEmployee
		this.awardBonus = function(bonus) {this.salary += bonus;}
	}

	var e1 = new Employee("Homer","IT",30000);
	var e2 = new Employee("Marge","HR",40000);

	print("Employees Before Bonus\n");
	print(e1);
	print(e2);

	e1.awardBonus(500);
	e2.awardBonus(1000);

	print("Employees After Bonus\n");
	print(e1);
	print(e2);