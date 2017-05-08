import java.io.*;
import java.util.*;

public class AccountDriver{
	public static void main(String[] args) throws IOException{
	int x;
	Scanner sc = new Scanner (System.in);


	do{

		File originalFile=new File("Input.txt");
		FileInputStream input=new FileInputStream(originalFile);
		Scanner infile= new Scanner(input);
            System.out.println("1. Display Account Info for all Accounts \n"+
			"2. Display Account Info for a particular Account\n"+
			"3. Withdraw\n"+
			"4. Deposit\n"+
			"5. Transfer\n"+
			"6. Add New Account\n"+
			"7. Delete Account\n"+
			"8. Exit \n \n \n"+
			"Please select your choice:")	;
        x = sc.nextInt();
        switch(x){
            case 1:
            	System.out.println("AccountID\tAccount Owner\tAccount Balance (SAR)");
            	while(infile.hasNextLine()){
            		int AccountID=infile.nextInt();
            		String name=infile.next().trim(),name2=infile.next().trim();
            		double balance=infile.nextDouble();
                	System.out.println(AccountID+"\t\t"+name+" "+name2+"\t  \t"+balance);
            	}

            	System.out.println("\n\nPress Enter key to continue . . .");
            	pressKey();

            	break;



            case 2:
            	System.out.print("Enter accountID:");
        		int ID=sc.nextInt();
        		boolean b=false;
            	while(infile.hasNextLine()){
            		int AccountID=infile.nextInt();
            		String name=infile.next(),name2=infile.next();
            		double balance=infile.nextDouble();
            		if(AccountID==ID){
            			System.out.print("AccountID: "+AccountID+"\t\tAccount Owner: "+name+" "+ name2 +"\t\tAccount Balance: "+balance);
            			b=true;
            		}

            	}
            	if(!b){
        			System.out.print("Error: Invalid account number");
        		}

            	System.out.println("\n\nPress Enter key to continue . . .");
            	pressKey();
            	 break;



            case 3:
            	System.out.println("Please enter accountID:");
            	int id=sc.nextInt();
            	System.out.println("Please enter withdraw amount (SAR):");
            	double amount=sc.nextDouble();
            	boolean b1=false;
            	int count =0;
            	if(amount<0){
            		System.out.println("Error: Invalid withdraw amount");
            		System.out.println("\n\nPress Enter key to continue . . .");
                	pressKey();
            		break;
            	}
            		while(infile.hasNextLine()){
                		int AccountID=infile.nextInt();
                		String name=infile.next(),name2=infile.next();
                		double balance=infile.nextDouble();
                		count++;
                		if(AccountID==id){
                			b1=true;
                			}
                		}

            		if(!b1){
            			System.out.println("Error: Invalid ID");
            			System.out.println("\n\nPress Enter key to continue . . .");
                    	pressKey();
            			break;
            		}
            	FileInputStream input11=new FileInputStream("Input.txt");//renamed scanner//
        		Scanner infile11= new Scanner(input11);
            	Account[] accounts =new Account[count];


            		int count2=0;
            		while(infile11.hasNextLine()){
            			int AccountID=infile11.nextInt();
                		String name=infile11.next(),name2=infile11.next();
                		double balance=infile11.nextDouble();
                		accounts[count2]=new Account(AccountID,name+" "+name2,balance);
                		count2++;
            		    }

            			Account accountdummy = new Account();
            			accountdummy.setID(id);
            			double i ;
            			for(int y=0;y<accounts.length;y++){
            				if(accountdummy.equals(accounts[y])){
            					if(accounts[y].getBalance()<amount){
            						System.out.println("Error: Insufficient balance. Balance available is only "+accounts[y].getBalance()+"  SAR");

            						break;
            					}else{
            					System.out.println("Balance before withdrawal : "+accounts[y].getBalance()+"  Saudi Riyals");
            					System.out.println("Amount withdrawn from Account:"+amount);

            				i=accounts[y].getBalance()-amount;
            					accounts[y].withdraw(i);
            					System.out.println("new balance: "+accounts[y].getBalance()+"  Saudi Riyals");
            				}
            					}
            			}
            			File temp=new File("input.txt");
            			FileOutputStream output1= new FileOutputStream(temp);
            			PrintWriter pw1= new PrintWriter(output1);
            			for(int y=0 ; y<accounts.length;y++){
            					if(accounts.length-1==y){
            					int nID=accounts[y].getAccountID();
                				String nName=accounts[y].getName();
                				double nBalance=accounts[y].getBalance();
                				pw1.print(nID+"\t\t"+nName+"\t\t"+nBalance);
                				break;
            					}else{
            				int nID=accounts[y].getAccountID();
            				String nName=accounts[y].getName();
            				double nBalance=accounts[y].getBalance();
            				pw1.println(nID+"\t\t"+nName+"\t\t"+nBalance);
            					}
            			}
            	pw1.close();
            	infile11.close();
            	System.out.println("\n\nPress Enter key to continue . . .");
            	pressKey();

            	 break;
            case 4:
            	System.out.println("Please enter accountID:");
            	int id1=sc.nextInt();
            	System.out.println("Please enter deposit amount (SAR):");
            	double amount1=sc.nextDouble();
            	boolean b11=false;
            	int count3 =0;
            	if(amount1<0){
            		System.out.println("Error: Invalid withdraw amount");
            		System.out.println("\n\nPress Enter key to continue . . .");
                	pressKey();
            		break;
            	}
            		while(infile.hasNextLine()){
                		int AccountID=infile.nextInt();
                		String name=infile.next(),name2=infile.next();
                		double balance=infile.nextDouble();
                		count3++;
                		if(AccountID==id1){
                			b11=true;
                			}
                		}

            		if(!b11){
            			System.out.println("Error: Invalid ID");
            			System.out.println("\n\nPress Enter key to continue . . .");
                    	pressKey();
            			break;
            		}
            	FileInputStream input22=new FileInputStream("Input.txt");//renamed scanner//
        		Scanner infile22= new Scanner(input22);
            	Account[] accounts1 =new Account[count3];


            		int count4=0;
            		while(infile22.hasNextLine()){
            			int AccountID=infile22.nextInt();
                		String name=infile22.next(),name2=infile22.next();
                		double balance=infile22.nextDouble();
                		accounts1[count4]=new Account(AccountID,name+" "+name2,balance);
                		count4++;
            		    }

            			Account accountdummy1 = new Account();
            			accountdummy1.setID(id1);
            			double q ;
            			for(int y=0;y<accounts1.length;y++){
            				if(accountdummy1.equals(accounts1[y])){
            					System.out.println("Balance before withdrawal : "+accounts1[y].getBalance()+"  Saudi Riyals");
            					System.out.println("Amount withdrawn from Account:"+amount1);
            				q=accounts1[y].getBalance()+amount1;
            					accounts1[y].deposit(q);
            					System.out.println("new balance: "+accounts1[y].getBalance()+"  Saudi Riyals");
            				}
            			}
            			File temp1=new File("input.txt");
            			FileOutputStream output11= new FileOutputStream(temp1);
            			PrintWriter pw2= new PrintWriter(output11);
            			for(int y=0 ; y<accounts1.length;y++){
            					if(accounts1.length-1==y){
            					int nID=accounts1[y].getAccountID();
                				String nName=accounts1[y].getName();
                				double nBalance=accounts1[y].getBalance();
                				pw2.print(nID+"\t\t"+nName+"\t\t"+nBalance);
                				break;
            					}else{
            				int nID=accounts1[y].getAccountID();
            				String nName=accounts1[y].getName();
            				double nBalance=accounts1[y].getBalance();
            				pw2.println(nID+"\t\t"+nName+"\t\t"+nBalance);
            					}
            			}
            	pw2.close();
            	infile22.close();

            	System.out.println("\n\nPress Enter key to continue . . .");
            	pressKey();

            	 break;
           //case 5 works fine
            case 5:
            	System.out.println("Please enter source accountID:");
            	int idS=sc.nextInt();
            	System.out.println("Please enter destination accountID:");
            	int idD=sc.nextInt();
            	System.out.println("Please enter Transfer amount (SAR):");
              	double amountT=sc.nextDouble();
            	FileInputStream FIS = new FileInputStream("input.txt");
            	FileInputStream FIS2 = new FileInputStream("input.txt");
            	FileInputStream FIS3 = new FileInputStream("input.txt");
            	Scanner reader = new Scanner(FIS);
            	Scanner reader2 = new Scanner(FIS2);
            	Scanner reader3 = new Scanner(FIS3);
            	if(amountT <= 0){
            		System.out.println("Error: Invalid Transfer amount");
            		System.out.println("\n\nPress Enter key to continue . . .");
                	pressKey();
            		break;
            	}

        		boolean search = false;
        		int counter1 = 0 ;
        		while(reader.hasNextLine()){
        			int  id11 = reader.nextInt();
        			String fName = reader.next();
        			String lName = reader.next();
        			double Balance = reader.nextDouble();
        			if(id11 == idS){
        				search = true ;
        			}
        			counter1++;
        		}
        		if (!search){
        			System.out.println("wrong source ID");
        			System.out.println("\n\nPress Enter key to continue . . .");
                	pressKey();
        			break;
        		}
        		reader.close();
         		boolean search2 = false;
         		int counter2 = 0;
         		while(reader2.hasNextLine()){
        			int  id11 = reader2.nextInt();
        			String fName = reader2.next();
        			String lName = reader2.next();
        			double Balance = reader2.nextDouble();
        			if(id11 == idD){
        				search2 = true ;
        			}
        			counter2++;
        		}

        		if (!search2){
        			System.out.println("wrong distenation ID");
        			System.out.println("\n\nPress Enter key to continue . . .");
                	pressKey();
        			break;
        		}

        		reader2.close();
        		Account[] allAccounts =new Account[counter1];
            	int counter4 = 0 ;
        		while(reader3.hasNextLine()){
        			int AccountID=reader3.nextInt();
            		String name=reader3.next(),name2=reader3.next();
            		double balance=reader3.nextDouble();
            		allAccounts[counter4]=new Account(AccountID,name+" "+name2,balance);
            		counter4++;
        		}
        		reader3.close();
        			Account accountdumm2 = new Account();
        			accountdumm2.setID(idS);
        			for(int w=0;w<allAccounts.length;w++){
        				if(accountdumm2.equals(allAccounts[w])){
        					if(allAccounts[w].getBalance()<amountT){
        						System.out.println("Error: Insufficient balance. Balance available is only "+allAccounts[w].getBalance()+"  SAR");

        						break;

        					}
        		}
        	}

        		Account accountdummy2 = new Account();
    			accountdummy2.setID(idS);
    			Account accountdummy3 = new Account();
    			accountdummy3.setID(idD);
    			double j ;
    			for(int y=0;y<allAccounts.length;y++){
    				if(accountdummy2.equals(allAccounts[y])){
    					for(int k = 0 ; k<allAccounts.length; k++){
    						if(accountdummy3.equals(allAccounts[k])){
    						System.out.println("Source Balance before transfer : "+allAccounts[y].getBalance()+"  Saudi Riyals");
        					System.out.println("Amount transfered from Account:"+amountT);
        				double a = allAccounts[y].getBalance() - amountT;
        				allAccounts[y].withdraw(a);
        				allAccounts[k].transfer(amountT,allAccounts[k]);
        					System.out.println("new balance : "+allAccounts[y].getBalance()+"  Saudi Riyals");
    						}
    					}
    				}
    			}
    			File temp2=new File("input.txt");
    			FileOutputStream output12= new FileOutputStream(temp2);
    			PrintWriter pw3= new PrintWriter(output12);
    			for(int y=0 ; y<allAccounts.length;y++){
    					if(allAccounts.length-1==y){
    					int nID=allAccounts[y].getAccountID();
        				String nName=allAccounts[y].getName();
        				double nBalance=allAccounts[y].getBalance();
        				pw3.print(nID+"\t\t"+nName+"\t\t"+nBalance);
        				break;
    					}
    					else{
    				int nID=allAccounts[y].getAccountID();
    				String nName=allAccounts[y].getName();
    				double nBalance=allAccounts[y].getBalance();
    				pw3.println(nID+"\t\t"+nName+"\t\t"+nBalance);
    					}
    			}
    	pw3.close();



            	System.out.print("\n\nPress Enter key to continue . . .");
            	pressKey();

            	break;
        //case 6 works fine
            case 6:
            	System.out.println("\n\nEnter Account ID");
            	int Oid = sc.nextInt();
            	System.out.println("\n\nEnter Account owner's name [first and last only]");
                 String OFname = sc.next(); String OLname = sc.next();
                 System.out.println("\n\nEnter Account Balance");
                 double ACbalance = sc.nextDouble();
                 FileInputStream FIS4 = new FileInputStream("input.txt");
                 FileInputStream FIS5 = new FileInputStream("input.txt");
             	Scanner reader4 = new Scanner(FIS4);
            	Scanner reader5 = new Scanner(FIS5);
                 boolean search3 = false;
         		int counter3 = 0;
         		while(reader4.hasNextLine()){
        			int  id11 = reader4.nextInt();
        			String fName = reader4.next();
        			String lName = reader4.next();
        			double Balance = reader4.nextDouble();
        			if(id11 == Oid){
        				search3 = true ;
        			}
        			counter3++;
        		}
         		if(search3){
         			System.out.println("\n\nError Account already exist");
         			break;
         		}

              reader4.close();

    	Account[] allAccounts2 =new Account[counter3];
    	int counter6 = 0 ;
		while(reader5.hasNextLine()){
			int AccountID=reader5.nextInt();
    		String name=reader5.next(),name2= reader5.next();
    		double balance=reader5.nextDouble();
    		allAccounts2[counter6]=new Account(AccountID,name+" "+name2,balance);
    		counter6++;
		}

		       reader5.close();
		       FileOutputStream FOS2 = new FileOutputStream("input.txt");
                PrintWriter pw5 = new PrintWriter(FOS2);

                for(int y=0 ; y<allAccounts2.length;y++){
					if(allAccounts2.length-1==y){
					int nID=allAccounts2[y].getAccountID();
    				String nName=allAccounts2[y].getName();
    				double nBalance=allAccounts2[y].getBalance();
    				pw5.print(nID+"\t\t"+nName+"\t\t"+nBalance);
    				break;
					}else{
				int nID=allAccounts2[y].getAccountID();
				String nName=allAccounts2[y].getName();
				double nBalance=allAccounts2[y].getBalance();
				pw5.println( nID +"\t\t"+nName+"\t\t"+nBalance);
					}
			}
                pw5.println();
            	pw5.print( Oid+"\t\t"+OFname +" "+OLname+"\t\t"+ACbalance);
                pw5.close();
            	System.out.println("\n\nPress Enter key to continue . . .");
            	pressKey();

            	 break;
            case 7:
            	System.out.println("Enter account ID to delete.");
            	int deletionAcc = sc.nextInt();
            	FileInputStream delStream = new FileInputStream("input.txt");
            	Scanner delScan = new Scanner(delStream);
            	int delCount0=0;
            	boolean delFound=false;
            	while(delScan.hasNextLine()){
            		int delIDSearch = delScan.nextInt();
            		String aaa = delScan.next();
            		String bbb = delScan.next();
            		double yyy = delScan.nextDouble();
            		delCount0++;
            		if(delIDSearch==deletionAcc){
            			delFound=true;
            		}
            	}
            	delScan.close();
            	if(!delFound){
            		System.out.println("Account not found.");
            		System.out.println("\n\nPress Enter key to continue . . .");
            		pressKey();
            		break;
            	}
            	FileOutputStream delOutStrm = new FileOutputStream("temp.txt",true);
            	PrintWriter delPrint = new PrintWriter(delOutStrm);
            	FileInputStream delStream2 = new FileInputStream("input.txt");
            	Scanner delScan2 = new Scanner(delStream2);
            	int delCount1=0;
            	while(delScan2.hasNextLine()){
            		++delCount1;
            		String delLine1 = delScan2.nextLine();
            		if(delCount1!=delCount0)
            			delPrint.println(delLine1);
            		else
            			delPrint.print(delLine1);
            	}
            	delPrint.close();
            	delScan2.close();
            	FileOutputStream delOutStrm2 = new FileOutputStream("input.txt");
            	PrintWriter delPrint2 = new PrintWriter(delOutStrm2);
            	delPrint2.print("");
            	delPrint2.close();
            	FileOutputStream delOutStrm3 = new FileOutputStream("input.txt",true);
            	PrintWriter delPrint3 = new PrintWriter(delOutStrm3);
            	FileInputStream delStream3 = new FileInputStream("temp.txt");
            	Scanner delScan3 = new Scanner(delStream3);
            	int delCount2=0;
            	delCount0-=1;
            	while(delScan3.hasNextLine()){
            		int iii = delScan3.nextInt();
            		String fff = delScan3.next();
            		String lll = delScan3.next();
            		double mmm = delScan3.nextDouble();
            		if(!(deletionAcc==iii))
            			if(delCount2!=delCount0-1){
            				delPrint3.println(iii+"\t\t"+fff+" "+lll+"\t\t"+mmm);
            				++delCount2;
            				}
            			else{
	            			delPrint3.print(iii+"\t\t"+fff+" "+lll+"\t\t"+mmm);
            				++delCount2;
            				}
            	}
            	delPrint3.close();
            	delScan3.close();
				FileOutputStream delOutStrm4 = new FileOutputStream("temp.txt");
            	PrintWriter delPrint4 = new PrintWriter(delOutStrm4);
            	delPrint4.print("");
            	delPrint4.close();
            	System.out.println("Account deleted");
            	System.out.println("\n\nPress Enter key to continue . . .");
            	pressKey();
            	break;
            case 8:
            	 break;
            default : System.out.println("\n\nInvalid choice\n \n");
        }
    	infile.close();


        } while( x != 8);





	}
	public static String pressKey(){
		Scanner sc = new Scanner (System.in);
		return sc.nextLine();
	}
}