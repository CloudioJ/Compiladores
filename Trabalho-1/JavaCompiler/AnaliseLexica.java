import java.io.*;

enum TokenType{ NUM ,SOMA, SUB, MULT, DIV, APar, FPar, EOF }

class Token{
  String lexema;
  TokenType token;

 Token (String l, TokenType t)
 	{ lexema=l;token = t;}	

}

class AnaliseLexica {

	PushbackReader arquivo;

	AnaliseLexica(String a) throws Exception
	{
		
	 	this.arquivo = new PushbackReader(new FileReader(a));
		
	}

	Token getNextToken() throws Exception {	
	  
		int eof = -1;
		int currchar1;
		StringBuilder builder = new StringBuilder();

		char currchar;
		
		do {
			currchar1 =  arquivo.read();
			currchar = (char) currchar1;
		} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');
		
		if (currchar1 == eof){
		  arquivo.close();
		  return new Token ("", TokenType.EOF);
		}
		
		if (currchar >= '0' && currchar <= '9'){
      builder.append(currchar);
	    while (true) {
	      currchar1 = arquivo.read();
	      if(currchar1 == eof){
	        break;
	      }
	    
	      currchar = (char) currchar1;
	      
	      if (currchar >= '0' && currchar <= '9'){
	        builder.append(currchar);
	      } else {
	        arquivo.unread(currchar1);
	        break;
	      }
	    }
		  System.out.println(builder.toString());
			return new Token (builder.toString(), TokenType.NUM);
		}
			
		switch (currchar){
			case '(':
				return new Token (Character.toString(currchar),TokenType.APar);
			case ')':
				return new Token (Character.toString(currchar),TokenType.FPar);
			case '+':
				return new Token (Character.toString(currchar),TokenType.SOMA);
			case '*':
				return new Token (Character.toString(currchar),TokenType.MULT);
		  case '-':
		    return new Token (Character.toString(currchar),TokenType.SUB);
	    case '/':
	      return new Token (Character.toString(currchar),TokenType.DIV);
			default: 
			  throw new Exception("Caractere inválido: " + ((int) currchar));
		}
	}
}
