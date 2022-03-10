class Employee
  attr_reader :salary
  def initialize(name,age,salary)
    @name = name
    @age = age
    @salary = salary
    @addresses =[]
  end
  def awardBonus(bonus)
    @salary += bonus
  end
  def addAddress(address)
    @addresses.push(address)
  end
  def locations()
    msg = "Lives at "
    @addresses.each {|a| msg << a << " " }
    return msg
  end
  def to_s
    return "#@name of age #@age earning #@salary"
  end
end

e = Employee.new("Dave Smith",32,35000)
puts e.inspect()
puts e.salary
puts e

e.addAddress("10 Arcatia Road")
e.addAddress("11 Privet Drive")
puts e.locations()

puts e.inspect()