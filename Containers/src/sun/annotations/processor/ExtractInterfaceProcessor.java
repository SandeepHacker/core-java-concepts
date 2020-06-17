package sun.annotations.processor;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.Elements;

@SupportedAnnotationTypes("sun.annotations.processor.ExtractInterface")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ExtractInterfaceProcessor extends AbstractProcessor {
	private String interfaceName;

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		List<Element> methods = new ArrayList<Element>();
		PackageElement pack=null;
		StringBuilder sb = new StringBuilder("package ");
		for (Element e1 : roundEnv.getElementsAnnotatedWith(ExtractInterface.class)) {
			interfaceName = e1.getAnnotation(ExtractInterface.class).interfaceName();
			TypeElement type = (TypeElement) e1;
			for (Element tp : type.getEnclosedElements()) {
				if (tp.getKind().equals(ElementKind.METHOD) && tp.getModifiers().contains(Modifier.PUBLIC)
						&& !tp.getModifiers().contains(Modifier.STATIC)) {
					methods.add(tp);
				}
			}
			if (methods.size() > 0) {
				Elements eu = processingEnv.getElementUtils();
			
				for (Element e : methods) {
					if(pack==null) {
					  pack = eu.getPackageOf(e);
					sb.append(pack.toString() + ";\npublic interface ").append(interfaceName).append("{\n\n");
					}
					ExecutableElement ee = (ExecutableElement) e;
					sb.append("\tpublic ").append(ee.getReturnType()).append(" ").append(ee.getSimpleName())
							.append("(");
					if (ee.getParameters().size() > 0)
						sb.append(createArguments(ee.getParameters()));
					sb.append(");");
					sb.append("\n\n");
				}
				sb.append("}");
	
			}

		}
	
		try (Writer wr = processingEnv.getFiler().createSourceFile(interfaceName).openWriter()){
			String[] arr = sb.toString().split("\n");
			for(String ss : arr) {
			wr.write(ss);
			wr.write("\r\n");
			}
			wr.close();
		} catch (IOException e) {
//			e.printStackTrace();
		}

		return false;
	}

	String createArguments(List<? extends Element> listargs) {
		StringBuilder sb = new StringBuilder();
		for (Element e : listargs) {
			VariableElement ve = (VariableElement) e;
			String s = ve.asType().toString();
			if(s.contains("."))
			sb.append(s.substring(s.lastIndexOf(".")+1)).append(" ").append(ve).append(", ");
			else
			sb.append(s).append(" ").append(ve).append(", ");
		}
		sb.deleteCharAt(sb.lastIndexOf(","));

		return sb.toString();

	}

}
