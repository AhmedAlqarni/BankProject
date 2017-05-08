
public class Account {
		private int accountID;
		private String   name;
		private double  balance;


		  //constructor//
		public Account(int AccountID , String name,double balance){     //constructor//
			this.accountID= AccountID;
			this.name=name;
			this.balance=balance;
		}
		public Account(){

		}

		//getter methods//
		public int getAccountID(){
			return accountID;
		}
		public String getName(){
			return name;
		}
		public double getBalance(){
			return balance;
		}

		public void setID(int x){
			accountID=x;
		}


		//setter methods//
		public void deposit(double amount)throws IllegalArgumentException{
			if(amount<=0){throw new IllegalArgumentException("Error: Deposit amount <= 0");}
			balance=amount;
		}

		public void withdraw(double amount)throws IllegalArgumentException{
			if(amount>balance){throw new IllegalArgumentException("Error: Withdraw amount > balance. the balance is"+balance);}
			balance=amount;
		}

		public void transfer(double amount,Account destinationAccount)throws IllegalArgumentException{   // need rewrinting//
			if(amount<=0){throw new IllegalArgumentException("invalid amount");}
		   balance = balance + amount ;


		}
			//toSting//
		public String toString(){
			return "the AccountID :"+ accountID + "\t\tAccount Owner :"+ name  +"\t\t Account Balance: "+balance;
		}

		//equals method//

		public boolean equals(Object obj){
			if(obj==null){
				return false;
			}else if( this.getClass()!=obj.getClass()){
				return false;
			}else{
				Account theOtherAccount = (Account)obj;
				return accountID== theOtherAccount.accountID;
			}

		}




}


