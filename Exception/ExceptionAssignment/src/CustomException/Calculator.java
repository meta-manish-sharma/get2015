package CustomException;

public class Calculator {

	private int firstNumber;
	private int secondNumber;
	int result = 0;

	public int getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(int firstNumber) {
		this.firstNumber = firstNumber;
	}

	public int getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(int secondNumber) {
		this.secondNumber = secondNumber;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int sum(int firstNumber,int secondNumber){
		result = firstNumber + secondNumber;
		return result;
	}
	
	public int subtraction(int firstNumber,int secondNumber){
		result = firstNumber - secondNumber;
		return result;
	}
	
	public int multiply(int firstNumber,int secondNumber){
		result = firstNumber * secondNumber;
		return result;
	}
	
	public int division(int firstNumber,int secondNumber) throws CustomException{
		try {
			result = firstNumber / secondNumber;
		} catch (ArithmeticException e) {
			throw new CustomException("can't divide by zero",e);
		}
		return result;
	}

}
