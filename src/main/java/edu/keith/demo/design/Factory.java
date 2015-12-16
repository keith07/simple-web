package edu.keith.demo.design;

public class Factory {

	class SimpleFactory{
		public SimpleProductor produce(){
			return new SimpleProductor();
		}
	}
	class SimpleProductor{
		
	}
}

class Factory1{
	abstract class AbstractFactory<T>{
		public abstract T produce();
	}
	class Factory11 extends AbstractFactory<AbstractProductor>{
		public AbstractProductor produce(){
			return new Productor1();
		}
	}
	
	interface AbstractProductor{
	}
	class Productor1 implements AbstractProductor{
		
	}
}

class Factory2{
	abstract class AbstractFactory{
		public abstract AbstractProductor1 produce1();
		public abstract AbstractProductor2 produce2();
	}
	
	interface AbstractProductor{
		
	}
	interface AbstractProductor1 extends AbstractProductor{
		
	}
	interface AbstractProductor2 extends AbstractProductor{
		
	}
}
