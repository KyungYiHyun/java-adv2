package annotation.basic;

import java.lang.annotation.Annotation;

@AnnoMeta
public class MetaData {

//    @AnnoMeta
//    private String id;

    @AnnoMeta
    public void call(){

    }

    public static void main(String[] args) throws NoSuchMethodException {
        Annotation annotation = MetaData.class.getAnnotation(AnnoMeta.class);
        System.out.println("annotation = " + annotation);

        Annotation annotation1 = MetaData.class.getMethod("call").getAnnotation(AnnoMeta.class);
        System.out.println("annotation1 = " + annotation1);

    }
}
