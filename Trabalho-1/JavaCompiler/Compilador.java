import java.util.Stack;

class Compilador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
		String resultado;

		try{

			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
		
			arv = as.parseProg();
		
			Interpretador inter = new Interpretador();
			resultado = inter.interpreta(arv);
			
			// CodeGen backend = new CodeGen();
			// String codigo = backend.geraCodigo(arv);
			System.out.println(resultado);

		}catch(Exception e)
		{			
			System.out.println("Erro de compilação:\n" + e);
		}



	}
}
