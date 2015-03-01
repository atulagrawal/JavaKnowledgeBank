package basics.protectedmodifier;

public class Foo {
	protected String getFoo() {
		return "foo";
	}
}

class Bar extends Foo {
	protected String getBar() {
		Foo foo = new Foo();
		System.out.println(getFoo());
		//no error as Foo and Bar are on same package. If Bar would have been in another package then complicaiton error would occur.
		System.out.println(foo.getFoo());
		return foo.getFoo();
	}
}
