package sun.annotations.processor;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;

import com.sun.source.util.Trees;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.code.TypeTag;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree.JCArrayTypeTree;
import com.sun.tools.javac.tree.JCTree.JCBlock;
import com.sun.tools.javac.tree.JCTree.JCClassDecl;
import com.sun.tools.javac.tree.JCTree.JCExpression;
import com.sun.tools.javac.tree.JCTree.JCFieldAccess;
import com.sun.tools.javac.tree.JCTree.JCIdent;
import com.sun.tools.javac.tree.JCTree.JCMethodDecl;
import com.sun.tools.javac.tree.JCTree.JCMethodInvocation;
import com.sun.tools.javac.tree.JCTree.JCModifiers;
import com.sun.tools.javac.tree.JCTree.JCNewClass;
import com.sun.tools.javac.tree.JCTree.JCStatement;
import com.sun.tools.javac.tree.JCTree.JCTypeParameter;
import com.sun.tools.javac.tree.JCTree.JCVariableDecl;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Name;
import com.sun.tools.javac.util.Names;

@SupportedAnnotationTypes("sun.annotations.processor.MakeBean")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class MakeBeanAnnotationProcessor extends AbstractProcessor {
	private int tally;
	private Trees trees;
	private TreeMaker mTreeMaker;

	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		trees = Trees.instance(processingEnv);
		Context context = ((JavacProcessingEnvironment) processingEnv).getContext();
		mTreeMaker = TreeMaker.instance(context);
		tally = 0;
	}

	private Name getName(String string) {
		Context context = ((JavacProcessingEnvironment) processingEnv).getContext();
		return Names.instance(context).fromString(string);
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(MakeBean.class);

		if (elements.size() > 0) {

			for (Element element : elements) {
				JCClassDecl classDecl = (JCClassDecl) trees.getTree(element);
				addMainMethod(classDecl, element.toString());
				addHelloMethod(classDecl);
				System.out.println("MakeBeanAnnotationProcessor.addMainMethod()" + classDecl);
				processingEnv.getMessager().printMessage(Kind.NOTE, "found @Log at " + element);
			}
		}
		/*
		 * java.util.List<Element> methods = new ArrayList<Element>(); for (Element e1 :
		 * roundEnv.getElementsAnnotatedWith(MakeBean.class)) { TypeElement type =
		 * (TypeElement) e1; Tree tt = trees.getTree(type); for (Element tp :
		 * type.getEnclosedElements()) { if (tp.getKind().equals(ElementKind.FIELD) &&
		 * !tp.getModifiers().contains(Modifier.FINAL) &&
		 * !tp.getModifiers().contains(Modifier.STATIC)) { methods.add(tp); } }
		 * 
		 * if (methods.size() > 0) { for(Element ve : methods) { VariableElement var =
		 * (VariableElement) ve; System.out.println(var); }
		 * 
		 * }
		 * 
		 * }
		 */

		/*
		 * int count = 1; while (flag) {
		 * 
		 * List<String> text = null; try { System.out.println(text =
		 * ReadFile.readAsList("sun\\annotations\\processor\\DataBean.java"));
		 * BufferedWriter fos = new BufferedWriter( new
		 * FileWriter("sun\\\\annotations\\\\processor\\\\DataBean.java"));
		 * 
		 * for (String ss : text) { // if(!ss.startsWith("@")) { fos.write(ss);
		 * fos.write("\r\n"); count++; if (count == 4)
		 * fos.write("public String name;\r\n"); // } } fos.flush(); fos.close(); }
		 * catch (IOException e) { e.printStackTrace(); } flag = false; }
		 */
		/*
		 * File ff = new File(".sun\\annotations\\processor\\Person.java");ff.delete();
		 * // try (Writer wr =
		 * processingEnv.getFiler().createSourceFile("sun.annotations.processor.Person")
		 * .openWriter()){ JavacFiler com = (JavacFiler) processingEnv.getFiler(); for
		 * (Element e1 : roundEnv.getElementsAnnotatedWith(MakeBean.class)) { String
		 * sourcePath; try { Writer wr = processingEnv.getFiler().createSourceFile(
		 * "sun.annotations.processor.DataBean").openWriter();
		 * 
		 * for(String ss : text) { if(!ss.startsWith("@")) { wr.write(ss);
		 * wr.write("\r\n"); } } wr.flush(); wr.close();
		 * 
		 * wr.close();
		 * 
		 * } catch (IOException e) { e.printStackTrace(); }
		 * 
		 * 
		 * }
		 * 
		 * 
		 * flag=false; }
		 */
		return true;
	}

	private void addMainMethod(JCClassDecl classDecl, String className) {
		JCModifiers modifiers = mTreeMaker.Modifiers(Flags.PUBLIC | Flags.STATIC);
		JCExpression returnType = mTreeMaker.TypeIdent(TypeTag.VOID);
		List<JCVariableDecl> parameters = makeMainParameters();
		List<JCTypeParameter> generics = List.nil();
		List<JCExpression> throwz = List.nil();
		JCBlock methodBody = makeMainBody(className);
		Name methodName = getName("main");

		JCMethodDecl mainMethodDecl = mTreeMaker.MethodDef(modifiers, methodName, returnType, generics, parameters,
				throwz, methodBody, null);

		try {
			classDecl.defs = classDecl.defs.append(mainMethodDecl);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private List<JCVariableDecl> makeMainParameters() {
		JCIdent paramType = mTreeMaker.Ident(getName("String"));

		JCArrayTypeTree paramArray = mTreeMaker.TypeArray(paramType);

		JCVariableDecl paramDecl = mTreeMaker.VarDef(mTreeMaker.Modifiers(Flags.PARAMETER), getName("args"), paramArray,
				null);

		return List.from(new JCVariableDecl[] { paramDecl });
	}

	private JCBlock makeMainBody(String className) {
		String[] strings = className.split("\\.");

		JCExpression classNameIdent = mTreeMaker.Ident(getName(strings[0]));

		for (int i = 1; i < strings.length; i++) {
			classNameIdent = mTreeMaker.Select(classNameIdent, getName(strings[i]));
		}

		JCNewClass classObj = mTreeMaker.NewClass(null, List.<JCExpression>nil(), classNameIdent,
				List.<JCExpression>nil(), null);

		JCFieldAccess printHello = mTreeMaker.Select(classObj, getName("printHello"));

		JCMethodInvocation printHelloInv = mTreeMaker.Apply(List.<JCExpression>nil(), printHello,
				List.<JCExpression>nil());

		JCStatement exec = mTreeMaker.Exec(printHelloInv);

		List<JCStatement> statements = List.of(exec);

		return mTreeMaker.Block(0, statements);
	}

	private void addHelloMethod(JCClassDecl classDecl) {
		JCModifiers modifiers = mTreeMaker.Modifiers(Flags.PRIVATE | Flags.FINAL);
		JCExpression returnType = mTreeMaker.TypeIdent(TypeTag.VOID);
		List<JCVariableDecl> parameters = List.nil();
		List<JCTypeParameter> generics = List.nil();
		Name methodName = getName("printHello");
		List<JCExpression> throwz = List.nil();
		JCBlock methodBody = makeHelloBody();

		JCMethodDecl helloMethodDecl = mTreeMaker.MethodDef(modifiers, methodName, returnType, generics, parameters,
				throwz, methodBody, null);

		classDecl.defs = classDecl.defs.append(helloMethodDecl);
	}

	private JCBlock makeHelloBody() {
		JCExpression printExpression = mTreeMaker.Ident(getName("System"));
		printExpression = mTreeMaker.Select(printExpression, getName("out"));
		printExpression = mTreeMaker.Select(printExpression, getName("println"));

		List<JCExpression> printArgs = List
				.from(new JCExpression[] { mTreeMaker.Literal("Hello from HelloProcessor!") });

		printExpression = mTreeMaker.Apply(List.<JCExpression>nil(), printExpression, printArgs);

		JCStatement call = mTreeMaker.Exec(printExpression);

		List<JCStatement> statements = List.from(new JCStatement[] { call });

		return mTreeMaker.Block(0, statements);
	}
}
