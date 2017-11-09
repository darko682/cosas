/* Generated By:JavaCC: Do not edit this line. lexico.java */
package rommel;
import java.io.*;
import java.util.Vector;
public class lexico implements lexicoConstants {

    public static Vector<String> contador = new Vector<String>();

        public static void main(String[] args)throws ParseException,TokenMgrError{

                try{

                        lexico analizador = new lexico(System.in);
                        analizador.Programa();
                        System.out.println("Se a compilado con exito.");

                }catch (ParseException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Error encontrado al realizar analisis");

                }


        }

  final public void Programa() throws ParseException {
        System.out.println("Sentencias");
        TokenAsignaciones.SetTables();
        TokenAsignaciones.Clean();
    try {
      jj_consume_token(MAIN);
      jj_consume_token(PARENTECISA);
      jj_consume_token(PARENTCISB);
      jj_consume_token(LLAVEA);
      Sentencias();
      jj_consume_token(LLAVEC);
      jj_consume_token(0);
    } catch (ParseException er) {
        contador.addElement(er.getMessage());
    }
  }

  final public void Sentencias() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ENTRADA:
      case HACERSI:
      case INT:
      case FLOAT:
      case STRING:
      case CARACTER:
      case IDENTIFICADOR:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INT:
      case FLOAT:
      case STRING:
      case CARACTER:
        VariablesLocales();
        break;
      case HACERSI:
        SentenciaIf();
        break;
      default:
        jj_la1[1] = jj_gen;
        if (jj_2_1(3)) {
          SentenciaAsignacion();
          jj_consume_token(PUNTOYCOMA);
                                                                TokenAsignaciones.segunda = 0;
        } else {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case ENTRADA:
            SentenciaWrite();
            break;
          default:
            jj_la1[2] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
      }
    }
  }

  final public void VariablesLocales() throws ParseException {
        int td;
        Token var;
    try {
      TiposDatos();
                               td = token.kind;
      var = jj_consume_token(IDENTIFICADOR);
                        System.out.println("Si entre a Variables Locales XXXXXX");
                        TokenAsignaciones.InsertarSimbolo(var,td);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ASIGNACION:
        VariablesAsignacion(var);
        break;
      default:
        jj_la1[3] = jj_gen;
        ;
      }
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMA:
          ;
          break;
        default:
          jj_la1[4] = jj_gen;
          break label_2;
        }
        jj_consume_token(COMA);
        var = jj_consume_token(IDENTIFICADOR);
                                                                       TokenAsignaciones.InsertarSimbolo(var, td);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ASIGNACION:
          VariablesAsignacion(var);
          break;
        default:
          jj_la1[5] = jj_gen;
          ;
        }
      }
      jj_consume_token(PUNTOYCOMA);
      Proceso();
    } catch (ParseException er) {
        System.out.println("eureca");
        contador.addElement(er.getMessage());
    }
  }

  final public void TiposDatos() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      jj_consume_token(INT);
      break;
    case FLOAT:
      jj_consume_token(FLOAT);
      break;
    case STRING:
      jj_consume_token(STRING);
      break;
    case CARACTER:
      jj_consume_token(CARACTER);
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Proceso() throws ParseException {
    Sentencias();
  }

//Sentencia IF
  final public void SentenciaIf() throws ParseException {
    jj_consume_token(HACERSI);
    jj_consume_token(PARENTECISA);
    A();
    jj_consume_token(PARENTCISB);
    jj_consume_token(LLAVEA);
    Sentencias();
    jj_consume_token(LLAVEC);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CONTRARIO:
      Sino();
      break;
    default:
      jj_la1[7] = jj_gen;
      ;
    }
  }

  final public void Sino() throws ParseException {
    jj_consume_token(CONTRARIO);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PARENTECISA:
      jj_consume_token(PARENTECISA);
      A();
      jj_consume_token(PARENTCISB);
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
    jj_consume_token(LLAVEA);
    Sentencias();
    jj_consume_token(LLAVEC);
  }

  final public void SentenciaAsignacion() throws ParseException {
        Token v1;
        Token v2;
        Token v3;
        int aux;
        String res;
        boolean imp = false;
    v1 = jj_consume_token(IDENTIFICADOR);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ASIGNACION:
      jj_consume_token(ASIGNACION);
      TiposAsignaciones();
    v2 = token;
        res = TokenAsignaciones.checkAsing(v1, v2);

        if(res != " ")
        {
                System.out.println(res);
                imp = true;
        }
      label_3:
      while (true) {
        if (jj_2_2(2)) {
          ;
        } else {
          break label_3;
        }
        OpAritmetico();
        TiposAsignaciones();
    v3 = token;
        res = TokenAsignaciones.checkAsing(v1, v3);

        if(res != " " && !imp)
        {
                System.out.println(res);
        }
      }
      break;
    case INCREMENTO:
    case DECREMENTO:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INCREMENTO:
        jj_consume_token(INCREMENTO);
        break;
      case DECREMENTO:
        jj_consume_token(DECREMENTO);
        break;
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
        res = TokenAsignaciones.checkVariable(v1);

        if(res != " ")
                System.out.println(res);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void VariablesAsignacion(Token v1) throws ParseException {
        Token v2;
        Token v3;
        String res;
        boolean imp = false;
    jj_consume_token(ASIGNACION);
    TiposAsignaciones();
                v2 = token;
                res = TokenAsignaciones.checkAsing(v1, v2);

                if(res != " ")
                {
                        System.out.println(res);
                        imp = true;
                }
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case RESTA:
      case SUMA:
      case MULTIPLICACION:
      case DIVISION:
      case NUMEROPOSITIVO:
      case DECIMAL:
      case CADENA:
      case CARACTER:
      case IDENTIFICADOR:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_4;
      }
      OpAritmetico();
      TiposAsignaciones();
                v3 = token;
                res = TokenAsignaciones.checkAsing(v1, v3);

                if(res != " " && !imp)
                {
                        System.out.println(res);
                }
    }
           System.out.println("pase");
  }

  final public void TiposAsignaciones() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFICADOR:
      jj_consume_token(IDENTIFICADOR);
      break;
    case NUMEROPOSITIVO:
      jj_consume_token(NUMEROPOSITIVO);
      break;
    case DECIMAL:
      jj_consume_token(DECIMAL);
      break;
    case CADENA:
      jj_consume_token(CADENA);
      break;
    case CARACTER:
      jj_consume_token(CARACTER);
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public int OpAritmetico() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SUMA:
      jj_consume_token(SUMA);
                   {if (true) return 1;}
      break;
    case RESTA:
      jj_consume_token(RESTA);
                    {if (true) return 1;}
      break;
    case MULTIPLICACION:
      jj_consume_token(MULTIPLICACION);
                             {if (true) return 1;}
      break;
    case DIVISION:
      jj_consume_token(DIVISION);
                       {if (true) return 1;}
      break;
    default:
      jj_la1[13] = jj_gen;
            {if (true) return 0;}
         {if (true) return 0;}
    }
    throw new Error("Missing return statement in function");
  }

  final public void OpAritmetico2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SUMA:
      jj_consume_token(SUMA);
      break;
    case RESTA:
      jj_consume_token(RESTA);
      break;
    case MULTIPLICACION:
      jj_consume_token(MULTIPLICACION);
      break;
    case DIVISION:
      jj_consume_token(DIVISION);
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void A() throws ParseException {
    Comparaciones();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OR:
      case AND:
      case DECIMAL:
      case IDENTIFICADOR:
        ;
        break;
      default:
        jj_la1[15] = jj_gen;
        break label_5;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OR:
      case AND:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case AND:
          jj_consume_token(AND);
          break;
        case OR:
          jj_consume_token(OR);
          break;
        default:
          jj_la1[16] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[17] = jj_gen;
        ;
      }
      Comparaciones();
    }
  }

//Fin sentencia if
  final public void Comparaciones() throws ParseException {
    Valor();
    Operadores();
    Valor();
  }

  final public void Valor() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFICADOR:
      jj_consume_token(IDENTIFICADOR);
      break;
    case DECIMAL:
      jj_consume_token(DECIMAL);
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    label_6:
    while (true) {
      OpAritmetico2();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFICADOR:
        jj_consume_token(IDENTIFICADOR);
        break;
      case DECIMAL:
        jj_consume_token(DECIMAL);
        break;
      default:
        jj_la1[19] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case RESTA:
      case SUMA:
      case MULTIPLICACION:
      case DIVISION:
        ;
        break;
      default:
        jj_la1[20] = jj_gen;
        break label_6;
      }
    }
  }

/*void Expresion():
{}
{
    LOOKAHEAD(2)

    (<DECIMAL> | <IDENTIFICADOR>)
	|(<IDENTIFICADOR>|<DECIMAL>) OpAritmetico() (<IDENTIFICADOR>|<DECIMAL>) 
}*/
  final public void Operadores() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MENOR:
      jj_consume_token(MENOR);
      break;
    case MAYOR:
      jj_consume_token(MAYOR);
      break;
    case IGUAL:
      jj_consume_token(IGUAL);
      break;
    case DIFERENTE:
      jj_consume_token(DIFERENTE);
      break;
    case MENORIGUAL:
      jj_consume_token(MENORIGUAL);
      break;
    case MAYORIGUAL:
      jj_consume_token(MAYORIGUAL);
      break;
    default:
      jj_la1[21] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*

void DeclaracionUnaVariable():
{
	int td;
	Token var;	
}
{	
	(TiposDatos())
	{
		td = token.kind;
	}
	var = <IDENTIFICADOR> 
	{		
		TokenAsignaciones.InsertarSimbolo(var, td);
	} 
	[VariablesAsignacion(var)]		
}

*/

//Sentencia WRITE

///cambiar todo este metodo SentenciaWrite
  final public void SentenciaWrite() throws ParseException {
    jj_consume_token(ENTRADA);
    jj_consume_token(MENOR);
    jj_consume_token(MENOR);
    jj_consume_token(PUNTOYCOMA);
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_3_2() {
    if (jj_3R_8()) return true;
    if (jj_3R_9()) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_3R_7()) return true;
    if (jj_scan_token(PUNTOYCOMA)) return true;
    return false;
  }

  private boolean jj_3R_9() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(55)) {
    jj_scanpos = xsp;
    if (jj_scan_token(50)) {
    jj_scanpos = xsp;
    if (jj_scan_token(52)) {
    jj_scanpos = xsp;
    if (jj_scan_token(53)) {
    jj_scanpos = xsp;
    if (jj_scan_token(54)) return true;
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_10() {
    if (jj_scan_token(ASIGNACION)) return true;
    if (jj_3R_9()) return true;
    return false;
  }

  private boolean jj_3R_11() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(17)) {
    jj_scanpos = xsp;
    if (jj_scan_token(18)) return true;
    }
    return false;
  }

  private boolean jj_3R_16() {
    return false;
  }

  private boolean jj_3R_15() {
    if (jj_scan_token(DIVISION)) return true;
    return false;
  }

  private boolean jj_3R_7() {
    if (jj_scan_token(IDENTIFICADOR)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_10()) {
    jj_scanpos = xsp;
    if (jj_3R_11()) return true;
    }
    return false;
  }

  private boolean jj_3R_14() {
    if (jj_scan_token(MULTIPLICACION)) return true;
    return false;
  }

  private boolean jj_3R_13() {
    if (jj_scan_token(RESTA)) return true;
    return false;
  }

  private boolean jj_3R_8() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_12()) {
    jj_scanpos = xsp;
    if (jj_3R_13()) {
    jj_scanpos = xsp;
    if (jj_3R_14()) {
    jj_scanpos = xsp;
    if (jj_3R_15()) {
    jj_scanpos = xsp;
    if (jj_3R_16()) return true;
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_12() {
    if (jj_scan_token(SUMA)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public lexicoTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[22];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
      jj_la1_init_2();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x12,0x10,0x2,0x10000,0x0,0x10000,0x0,0x40,0x40000000,0x60000,0x70000,0x780000,0x0,0x780000,0x780000,0x3000,0x3000,0x3000,0x0,0x0,0x780000,0x3f000000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0xc09400,0x409400,0x0,0x0,0x4,0x0,0x409400,0x0,0x0,0x0,0x0,0xf40000,0xf40000,0x0,0x0,0x900000,0x0,0x0,0x900000,0x900000,0x0,0x0,};
   }
   private static void jj_la1_init_2() {
      jj_la1_2 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[2];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public lexico(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public lexico(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new lexicoTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public lexico(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new lexicoTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public lexico(lexicoTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(lexicoTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[65];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 22; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 65; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 2; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
