package sun.annotations.processor;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
@SupportedAnnotationTypes("sun.annotations.processor.Simple")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class SimpleAnnotationProcessor extends AbstractProcessor{

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		for(TypeElement t : annotations) {
			System.out.println("Annotation Type:::"+t);
			for(Element el : roundEnv.getElementsAnnotatedWith(t)){
				System.out.println("Hacker::::"+el.getKind()+el.getModifiers()+el.getSimpleName()+el.asType());
				dispalyElement(el);
			}
		}
		
		return false;
	}
	
	
	public void dispalyElement(Element el) {
		
		
		if(el.getKind().equals(ElementKind.CLASS)) {
			TypeElement te = (TypeElement)el;
			System.out.println(te.getQualifiedName());
			System.out.println(te.getEnclosedElements());
			System.out.println(te.getModifiers());
			System.out.println(te.getSuperclass());
		}
		if(el.getKind().equals(ElementKind.CONSTRUCTOR) || el.getKind().equals(ElementKind.METHOD)) {
			ExecutableElement te = (ExecutableElement)el;
			System.out.println(te.getParameters());
			System.out.println(te.getEnclosedElements());
			System.out.println(te.getModifiers());
			System.out.println(te.getThrownTypes());
			System.out.println(te.getReturnType());
			System.out.println(te.getSimpleName());
			
		}
		if(el.getKind().equals(ElementKind.FIELD)) {
			VariableElement te = (VariableElement)el;

			System.out.println(te.getEnclosedElements());
			System.out.println(te.getModifiers());
			System.out.println(te.getSimpleName());
			System.out.println(te.asType().toString());
			
		}
	}

}
