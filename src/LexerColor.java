// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: src/LexerColor.flex

import compilerTools.TextColor;
import java.awt.Color;


// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
class LexerColor {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\12\0\1\1\1\2\1\0\1\3\34\0\1\4\1\5"+
    "\1\0\1\5\1\6\1\7\12\10\2\0\1\11\1\12"+
    "\1\13\2\0\3\14\1\15\26\14\4\0\1\16\1\0"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\14"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\1\37\1\40\1\41\1\42\1\43\2\14\1\44"+
    "\1\14\1\0\1\45\10\0\1\2\73\0\1\14\7\0"+
    "\1\14\3\0\1\14\3\0\1\14\1\0\1\14\6\0"+
    "\1\14\1\0\1\14\4\0\1\14\7\0\1\14\3\0"+
    "\1\14\3\0\1\14\1\0\1\14\6\0\1\14\1\0"+
    "\1\14\u012b\0\2\2\326\0\u0100\2";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\31\1\1\0\1\2\1\0\16\1\1\3\5\1"+
    "\1\3\2\1\2\0\2\2\34\1\1\0\1\2\1\0"+
    "\10\1\1\4\3\1\1\5\12\1\1\0\3\1\1\6"+
    "\3\1\1\7\5\1\1\7\6\1\1\0\12\1\1\0"+
    "\7\1\1\0\11\1";

  private static int [] zzUnpackAction() {
    int [] result = new int[160];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\46\0\114\0\162\0\230\0\276\0\344\0\u010a"+
    "\0\u0130\0\u0156\0\u017c\0\u01a2\0\u01c8\0\u01ee\0\u0214\0\u023a"+
    "\0\u0260\0\u0286\0\u02ac\0\u02d2\0\u02f8\0\u031e\0\u0344\0\u036a"+
    "\0\u0390\0\u03b6\0\u03dc\0\u0402\0\u0428\0\u044e\0\u0474\0\u049a"+
    "\0\u04c0\0\u04e6\0\u050c\0\u0532\0\u0558\0\u057e\0\u05a4\0\u05ca"+
    "\0\u05f0\0\u0616\0\u063c\0\u010a\0\u0662\0\u0688\0\u06ae\0\u06d4"+
    "\0\u06fa\0\u0720\0\u0746\0\u076c\0\u0792\0\u07b8\0\46\0\u07de"+
    "\0\u0804\0\u082a\0\u0850\0\u0876\0\u089c\0\u08c2\0\u08e8\0\u090e"+
    "\0\u0934\0\u095a\0\u0980\0\u09a6\0\u09cc\0\u09f2\0\u0a18\0\u0a3e"+
    "\0\u0a64\0\u0a8a\0\u0ab0\0\u0ad6\0\u0afc\0\u0b22\0\u0b48\0\u0b6e"+
    "\0\u0b94\0\u0bba\0\u0be0\0\u0c06\0\u0c2c\0\u0792\0\u0c52\0\u0c78"+
    "\0\u0c9e\0\u0cc4\0\u0cea\0\u0d10\0\u0d36\0\u0d5c\0\u0d82\0\u010a"+
    "\0\u0da8\0\u0dce\0\u0df4\0\u010a\0\u0e1a\0\u0e40\0\u0e66\0\u0e8c"+
    "\0\u0eb2\0\u0ed8\0\u0efe\0\u0f24\0\u0f4a\0\u0f70\0\u0f96\0\u0fbc"+
    "\0\u0fe2\0\u1008\0\u010a\0\u102e\0\u1054\0\u107a\0\u010a\0\u10a0"+
    "\0\u10c6\0\u10ec\0\u1112\0\u1138\0\u115e\0\u1184\0\u11aa\0\u11d0"+
    "\0\u11f6\0\u121c\0\u1242\0\u1268\0\u128e\0\u12b4\0\u12da\0\u1300"+
    "\0\u1326\0\u134c\0\u1372\0\u1398\0\u13be\0\u13e4\0\u140a\0\u1430"+
    "\0\u1456\0\u147c\0\u14a2\0\u14c8\0\u14ee\0\u1514\0\u153a\0\u1560"+
    "\0\u1586\0\u15ac\0\u15d2\0\u15f8\0\u161e\0\u1644\0\u166a\0\u1690";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[160];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\2\2\1\0\1\3\1\2\1\4\1\2\1\5\1\6"+
    "\1\7\2\4\3\10\1\11\1\12\1\13\1\10\1\14"+
    "\1\15\1\16\1\17\1\10\1\20\1\21\1\22\1\23"+
    "\1\24\1\25\1\10\1\26\1\27\1\30\1\10\1\31"+
    "\1\10\1\32\47\0\1\2\56\0\1\2\37\0\1\33"+
    "\2\0\1\34\44\0\1\35\1\0\1\6\47\0\2\2"+
    "\42\0\1\10\3\0\31\10\11\0\1\10\3\0\5\10"+
    "\1\36\23\10\11\0\1\10\3\0\20\10\1\37\10\10"+
    "\11\0\1\10\3\0\12\10\1\40\5\10\1\41\10\10"+
    "\11\0\1\10\3\0\17\10\1\42\11\10\11\0\1\10"+
    "\3\0\3\10\1\43\17\10\1\44\5\10\11\0\1\10"+
    "\3\0\12\10\1\45\16\10\11\0\1\10\3\0\16\10"+
    "\1\46\1\47\11\10\11\0\1\10\3\0\12\10\1\50"+
    "\16\10\11\0\1\10\3\0\7\10\1\51\21\10\11\0"+
    "\1\10\3\0\12\10\1\52\5\10\1\53\10\10\11\0"+
    "\1\10\3\0\20\10\1\54\10\10\11\0\1\10\3\0"+
    "\21\10\1\55\7\10\11\0\1\10\3\0\20\10\1\56"+
    "\2\10\1\57\5\10\11\0\1\10\3\0\20\10\1\60"+
    "\10\10\11\0\1\10\3\0\7\10\1\61\2\10\1\62"+
    "\16\10\11\0\1\10\3\0\20\10\1\63\10\10\11\0"+
    "\1\10\3\0\7\10\1\64\21\10\46\0\1\2\4\65"+
    "\1\66\41\65\1\34\1\67\1\34\1\70\42\34\6\0"+
    "\1\71\1\0\1\72\45\0\1\10\3\0\7\10\1\73"+
    "\21\10\11\0\1\10\3\0\4\10\1\74\24\10\11\0"+
    "\1\10\3\0\5\10\1\75\7\10\1\76\13\10\11\0"+
    "\1\10\3\0\20\10\1\77\10\10\11\0\1\10\3\0"+
    "\25\10\1\100\3\10\11\0\1\10\3\0\15\10\1\101"+
    "\13\10\11\0\1\10\3\0\7\10\1\102\21\10\11\0"+
    "\1\10\3\0\23\10\1\103\5\10\11\0\1\10\3\0"+
    "\21\10\1\104\7\10\11\0\1\10\3\0\30\10\1\105"+
    "\11\0\1\10\3\0\15\10\1\106\13\10\11\0\1\10"+
    "\3\0\7\10\1\107\21\10\11\0\1\10\3\0\7\10"+
    "\1\110\21\10\11\0\1\10\3\0\6\10\1\111\10\10"+
    "\1\112\5\10\1\113\3\10\11\0\1\10\3\0\5\10"+
    "\1\114\23\10\11\0\1\10\3\0\25\10\1\115\3\10"+
    "\11\0\1\10\3\0\7\10\1\116\21\10\11\0\1\10"+
    "\3\0\25\10\1\117\3\10\11\0\1\10\3\0\17\10"+
    "\1\120\11\10\11\0\1\10\3\0\2\10\1\121\26\10"+
    "\11\0\1\10\3\0\23\10\1\122\5\10\11\0\1\10"+
    "\3\0\15\10\1\123\1\10\1\124\11\10\1\0\4\65"+
    "\1\125\45\65\1\125\2\65\1\126\36\65\1\0\1\67"+
    "\52\0\1\71\6\0\1\127\40\0\1\72\45\0\1\10"+
    "\3\0\12\10\1\130\2\10\1\131\13\10\11\0\1\10"+
    "\3\0\12\10\1\132\16\10\11\0\1\10\3\0\15\10"+
    "\1\133\13\10\11\0\1\10\3\0\12\10\1\134\16\10"+
    "\11\0\1\10\3\0\15\10\1\135\13\10\11\0\1\10"+
    "\3\0\7\10\1\45\21\10\11\0\1\10\3\0\15\10"+
    "\1\136\13\10\11\0\1\10\3\0\17\10\1\137\11\10"+
    "\11\0\1\10\3\0\20\10\1\140\10\10\11\0\1\10"+
    "\3\0\23\10\1\141\5\10\11\0\1\10\3\0\7\10"+
    "\1\142\21\10\11\0\1\10\3\0\20\10\1\143\10\10"+
    "\11\0\1\10\3\0\23\10\1\144\5\10\11\0\1\10"+
    "\3\0\17\10\1\145\11\10\11\0\1\10\3\0\7\10"+
    "\1\146\21\10\11\0\1\10\3\0\25\10\1\147\3\10"+
    "\11\0\1\10\3\0\20\10\1\150\10\10\11\0\1\10"+
    "\3\0\12\10\1\151\16\10\11\0\1\10\3\0\7\10"+
    "\1\152\21\10\11\0\1\10\3\0\24\10\1\114\4\10"+
    "\11\0\1\10\3\0\3\10\1\55\25\10\11\0\1\10"+
    "\3\0\24\10\1\153\4\10\11\0\1\10\3\0\17\10"+
    "\1\23\11\10\11\0\1\10\3\0\22\10\1\154\6\10"+
    "\11\0\1\10\3\0\20\10\1\155\10\10\11\0\1\10"+
    "\3\0\25\10\1\156\3\10\1\0\4\65\1\125\2\65"+
    "\1\67\36\65\26\0\1\157\27\0\1\10\3\0\25\10"+
    "\1\160\3\10\11\0\1\10\3\0\7\10\1\161\21\10"+
    "\11\0\1\10\3\0\17\10\1\162\11\10\11\0\1\10"+
    "\3\0\20\10\1\163\10\10\11\0\1\10\3\0\17\10"+
    "\1\164\11\10\11\0\1\10\3\0\3\10\1\165\25\10"+
    "\11\0\1\10\3\0\3\10\1\166\25\10\11\0\1\10"+
    "\3\0\20\10\1\167\10\10\11\0\1\10\3\0\12\10"+
    "\1\170\16\10\11\0\1\10\3\0\5\10\1\171\23\10"+
    "\11\0\1\10\3\0\16\10\1\172\12\10\11\0\1\10"+
    "\3\0\25\10\1\173\3\10\11\0\1\10\3\0\15\10"+
    "\1\137\13\10\11\0\1\10\3\0\3\10\1\174\25\10"+
    "\11\0\1\10\3\0\23\10\1\175\5\10\11\0\1\10"+
    "\3\0\20\10\1\176\10\10\11\0\1\10\3\0\17\10"+
    "\1\177\11\10\11\0\1\10\3\0\20\10\1\200\10\10"+
    "\11\0\1\10\3\0\26\10\1\201\2\10\11\0\1\10"+
    "\3\0\5\10\1\202\23\10\11\0\1\10\3\0\12\10"+
    "\1\203\16\10\26\0\1\204\30\0\1\10\3\0\7\10"+
    "\1\167\21\10\11\0\1\10\3\0\23\10\1\205\5\10"+
    "\11\0\1\10\3\0\3\10\1\167\25\10\11\0\1\10"+
    "\3\0\6\10\1\206\22\10\11\0\1\10\3\0\17\10"+
    "\1\207\11\10\11\0\1\10\3\0\24\10\1\167\4\10"+
    "\11\0\1\10\3\0\16\10\1\210\12\10\11\0\1\10"+
    "\3\0\25\10\1\153\3\10\11\0\1\10\3\0\7\10"+
    "\1\211\21\10\11\0\1\10\3\0\23\10\1\212\5\10"+
    "\11\0\1\10\3\0\6\10\1\213\22\10\11\0\1\10"+
    "\3\0\2\10\1\214\26\10\11\0\1\10\3\0\17\10"+
    "\1\140\11\10\11\0\1\10\3\0\5\10\1\215\23\10"+
    "\11\0\1\10\3\0\23\10\1\167\5\10\11\0\1\10"+
    "\3\0\7\10\1\140\21\10\11\0\1\10\3\0\12\10"+
    "\1\216\16\10\11\0\1\10\3\0\15\10\1\205\13\10"+
    "\27\0\1\217\27\0\1\10\3\0\3\10\1\220\25\10"+
    "\11\0\1\10\3\0\23\10\1\137\5\10\11\0\1\10"+
    "\3\0\25\10\1\167\3\10\11\0\1\10\3\0\7\10"+
    "\1\144\21\10\11\0\1\10\3\0\25\10\1\221\3\10"+
    "\11\0\1\10\3\0\3\10\1\222\25\10\11\0\1\10"+
    "\3\0\20\10\1\223\10\10\11\0\1\10\3\0\3\10"+
    "\1\224\25\10\11\0\1\10\3\0\12\10\1\225\16\10"+
    "\11\0\1\10\3\0\6\10\1\226\22\10\42\0\1\227"+
    "\14\0\1\10\3\0\6\10\1\153\22\10\11\0\1\10"+
    "\3\0\23\10\1\230\5\10\11\0\1\10\3\0\24\10"+
    "\1\163\4\10\11\0\1\10\3\0\23\10\1\162\5\10"+
    "\11\0\1\10\3\0\23\10\1\231\5\10\11\0\1\10"+
    "\3\0\3\10\1\140\25\10\11\0\1\10\3\0\3\10"+
    "\1\232\25\10\35\0\1\233\21\0\1\10\3\0\3\10"+
    "\1\234\25\10\11\0\1\10\3\0\23\10\1\235\5\10"+
    "\11\0\1\10\3\0\6\10\1\140\22\10\16\0\1\127"+
    "\40\0\1\10\3\0\13\10\1\201\15\10\11\0\1\10"+
    "\3\0\3\10\1\236\25\10\11\0\1\10\3\0\17\10"+
    "\1\237\11\10\11\0\1\10\3\0\22\10\1\240\6\10"+
    "\11\0\1\10\3\0\26\10\1\160\2\10\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5814];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\30\1\1\0\1\1\1\0\27\1\2\0"+
    "\1\11\35\1\1\0\1\1\1\0\27\1\1\0\24\1"+
    "\1\0\12\1\1\0\7\1\1\0\11\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[160];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */
    private TextColor textColor(long start, int size, Color color){
        return new TextColor((int) start, size, color);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  LexerColor(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  public TextColor yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { /*Ignorar*/
            }
            // fall through
          case 8: break;
          case 2:
            { return textColor(yychar, yylength(), new Color(146, 146, 146));
            }
            // fall through
          case 9: break;
          case 3:
            { return textColor(yychar, yylength(), new Color(255, 0, 0));
            }
            // fall through
          case 10: break;
          case 4:
            { return textColor(yychar, yylength(), new Color(6, 90, 158));
            }
            // fall through
          case 11: break;
          case 5:
            { return textColor(yychar, yylength(), new Color(9, 110, 51));
            }
            // fall through
          case 12: break;
          case 6:
            { return textColor(yychar, yylength(), new Color(0, 0, 255));
            }
            // fall through
          case 13: break;
          case 7:
            { return textColor(yychar, yylength(), new Color(0, 255, 0));
            }
            // fall through
          case 14: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
