package LogicalUnit;

import java.util.*;

public final class ExpressionSolver implements UserInterface
{
    private String InputS,OUTPUT;
    Double OutputS;
    
    private Queue<String> Infix = new LinkedList();
    private Queue<String> Postfix = new LinkedList();
    
    public void TakeInput(String S)
    {
        InputS = resize(S);
    }
    private String resize(String S)
    {
        String OUT="";
        
        for(int i=0;i<S.length();i++)
        {
            if(S.charAt(i)=='=') continue;
                    
            else if(S.charAt(i)=='l'&&S.charAt(i+1)=='n') 
            {
                if(i>0 && Character.isDigit(S.charAt(i-1))) OUT+="*";
                OUT+="lon";i++;
            }
            else if(S.charAt(i)=='e') OUT+="2.71828";
            else if(S.charAt(i)=='(' && i>0 && Character.isDigit(S.charAt(i-1)) ) OUT+= "*(";
            else if(S.charAt(i)=='x') OUT+="*";
            else if(S.charAt(i)==')' && i<S.length()-1 && Character.isDigit(S.charAt(i+1))) OUT+= ")*";
            else if(Character.isAlphabetic(S.charAt(i)) && i>0 && Character.isDigit(S.charAt(i-1))) OUT+="*"+Character.toString(S.charAt(i));
            else OUT+= Character.toString(S.charAt(i));
        }
        //System.out.println(OUT);
        return OUT;
    }
    public void CheckError()
            throws CalculationException
    {
        if(InputS.length()==0) throw new CalculationException("Empty Input");
        
        if(InputS.charAt(0)=='+' ||InputS.charAt(0)=='-'
                ||InputS.charAt(0)=='*'||InputS.charAt(0)=='/')
        {
            throw new CalculationException("Syntax Error");
        }
        if(InputS.charAt(InputS.length()-1)=='+' ||InputS.charAt(InputS.length()-1)=='-'
                ||InputS.charAt(InputS.length()-1)=='*'||InputS.charAt(InputS.length()-1)=='/')
        {
            throw new CalculationException("Syntax Error");
        }
        
        Stack<String> S = new Stack();

        for(int i=0;i<InputS.length();i++)
        {
            if(InputS.charAt(i)=='(') S.push("(");
            
            else if(InputS.charAt(i)==')')
            {
                if(S.empty())
                {
                    throw new CalculationException("Parentheses Not Balanced");
                }
                else S.pop();
            }
            else if((InputS.charAt(i)=='*'||InputS.charAt(i)=='/'||InputS.charAt(i)=='+'||InputS.charAt(i)=='-')
                    &&((InputS.charAt(i+1)=='*'||InputS.charAt(i+1)=='/'||InputS.charAt(i+1)=='+'||InputS.charAt(i+1)=='-')
                    ||(InputS.charAt(i-1)=='*'||InputS.charAt(i-1)=='/'||InputS.charAt(i-1)=='+'||InputS.charAt(i-1)=='-')))
            {
                throw new CalculationException("Syntax Error");
            }
        }
        if(!S.empty()) throw new CalculationException("Parentheses Not Balanced"); 
            
        for(int i=InputS.length()-1;i>=0;i--)
        {
            if(Character.isAlphabetic(InputS.charAt(i)) 
                    && (!Character.isLetterOrDigit(InputS.charAt(i+1)) 
                    && InputS.charAt(i+1)!='(' )) throw new CalculationException("Syntax Error");
        }
    }
    private void StrToQueue()
    {
        int i = 0;
        Infix.add("(");
        while(i < InputS.length())
        {
            String S = new String("");

            while(i<InputS.length() && (Character.isDigit(InputS.charAt(i))|| InputS.charAt(i)== '.' ))
            {
                S = S + Character.toString(InputS.charAt(i));
                i++;
            }
            if(!S.equals("")) Infix.add(S);
            else if(InputS.charAt(i)=='^')
            {
                    Infix.add("^");
                    i++;
            }
            else if(InputS.charAt(i)=='!')
            {
                    Infix.add("!");
                    i++;
            }
            else
            {
                if(!Character.isLetterOrDigit(InputS.charAt(i)))
                {
                    Infix.add(Character.toString(InputS.charAt(i)));
                    i++;
                }
                else if(Character.isAlphabetic(InputS.charAt(i)))
                {
                    S = S + Character.toString(InputS.charAt(i))+ Character.toString(InputS.charAt(i+1))+ Character.toString(InputS.charAt(i+2));
                    Infix.add(S);
                    i+=3;
                }
            }
        }
        Infix.add(")");
      //  while(!Infix.isEmpty()) System.out.println(Infix.remove());
     }

    private void Infix_Postfix()
    {
        Stack<String> STK = new Stack();

        while(!Infix.isEmpty())
        {
            String S = Infix.remove();

            if(S.equals("(")) STK.push(S);
                
            else if(Character.isDigit(S.charAt(0)))
            {
                if(STK.peek().length() == 3 ||STK.peek().equals("!")) 
                {
                    String SR = STK.pop();
                    Postfix.add(S);
                    Postfix.add(SR);
                }
                else 
                {
                    Postfix.add(S);
                }
            }
            else if(S.equals(")"))
            {
                while(!STK.isEmpty()&&!STK.peek().equals("("))
                {
                    Postfix.add(STK.pop());
                }
                if(STK.peek().equals("(")) STK.pop();
                if(!STK.isEmpty()&&STK.peek().length()==3) Postfix.add(STK.pop());
            }
            else if(S.equals("^"))
            {
                while((STK.peek().equals("!")||STK.peek().equals("^")||STK.peek().length()==3)&&!STK.isEmpty())
                {
                    Postfix.add(STK.pop());
                }
                STK.push(S);
            }
            else if(S.equals("*")||S.equals("/"))
            {
                while((STK.peek().equals("*")||STK.peek().equals("/")||STK.peek().equals("^"))&&!STK.isEmpty())
                {
                    Postfix.add(STK.pop());
                }
                STK.push(S);
            }
            else if(S.equals("*")||S.equals("/"))
            {
                while((STK.peek().equals("*")||STK.peek().equals("/")||STK.peek().equals("^"))&&!STK.isEmpty())
                {
                    Postfix.add(STK.pop());
                }
                STK.push(S);
            }
            else if(S.equals("+")||S.equals("-"))
            {
                while(!STK.peek().equals("(")&&!STK.empty())
                {
                    Postfix.add(STK.pop());
                }
                STK.push(S);
            }
            else if(S.equals("!"))
            {
                Postfix.add(S);
                //if(S.equals("pow"))STK.push(ST);
            }
            else if(S.length()==3)
            {
                STK.push(S);
                //if(S.equals("pow"))STK.push(ST);
            }
        }
        // while(!Postfix.isEmpty()) System.out.println(Postfix.remove());
    }

    private Double Calculate() throws CalculationException
    {
        Stack<Double> STK = new Stack();
        while(!Postfix.isEmpty())
        {
            String S = Postfix.remove();

            if(Character.isDigit(S.charAt(0))) STK.push(Double.valueOf(S));
            
            else if(S.equals("!"))
            {
                double R = STK.pop();
                String RR = Double.toString(R);
                for(int i=0;i<RR.length();i++)
                {
                    if(RR.charAt(i)=='.'&&i==RR.length()-2 && RR.charAt(i+1)!='0')
                    {
                        throw new CalculationException("Syntax Error");
                    }
                }
                double D=1;
                while(R>0) 
                {
                    D*=R;
                    R--;
                }
                STK.push(D);
                
            }

            else if(S.length()==1)
            {
                double A = STK.pop();
                double B = STK.pop();

                if(S.equals("+")) STK.push(A+B);
                else if(S.equals("-")) STK.push(B-A);
                else if(S.equals("*")) STK.push(A*B);
                else if(S.equals("/")) STK.push(B/A);
                else if(S.equals("^")) STK.push(Math.pow(B, A));
            }
            else if(S.equals("sin")) STK.push(Math.sin(Math.toRadians(STK.pop())));
            else if(S.equals("cos")) STK.push(Math.cos(Math.toRadians(STK.pop())));
            else if(S.equals("tan")) STK.push(Math.tan(Math.toRadians(STK.pop())));
            else if(S.equals("log")) STK.push(Math.log10(STK.pop()));
            else if(S.equals("exp")) STK.push(Math.exp(STK.pop()));
            else if(S.equals("lon")) STK.push(2.303* Math.log10(STK.pop()));
        }
        return STK.pop();
    }

    public void Solve()
    {
        StrToQueue();
        Infix_Postfix();
        try{
            OutputS = Calculate();
        }
        catch(CalculationException e)
        {
            OUTPUT = e.toString();
        }
    }
    public String TakeOutput()
    {
        OUTPUT = OutputS.toString();
            return OUTPUT;
    }
}

