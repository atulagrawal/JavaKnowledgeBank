package basics.abstract_nested_class;
//This class tests the concept of nested abstract class
public class NestedAbstractClassTest {
	public static void main (String args[]) {
		Foo a = new Foo() {
			String foo() {
				return "foo";
			}
		};
		
		Foo.Bar b = a.new Bar() {
			String getBarName() {
				return "Bar";
			}
		};
	
	System.out.println(a.foo() + "-" + b.getBarName());
	}
	
}

abstract class Foo {
	abstract String foo();
	
	abstract class Bar {
		abstract String getBarName();
	}
}
