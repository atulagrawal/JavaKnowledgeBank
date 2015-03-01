package basics.test;

import basics.protectedmodifier.Foo;

class Bar extends Foo {
	protected String getBar() {
		Foo foo = new Foo();
		System.out.println(getFoo());
		
		//Error below as protected method can't be accessed in another package.
		//System.out.println(foo.getFoo());
		//return foo.getFoo();
		return "There is an eror";
	}
}