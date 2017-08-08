package lib.data.avatar.phrase;

/**
 * Created by 军军 on 2017/8/8.
 */

public class Phrase {

    /**
     * id : de24461a-5ef3-409b-bb0d-c15f505449b2
     * name : 龙马精神
     * spell : lóng mǎ jīng shén
     * content : 龙马：古代传说中形状象龙的骏马。比喻人精神旺盛。
     * derivation : 唐·李郢《上裴晋公》诗：“四朝忧国鬓如丝，龙马精神海鹤姿。”
     * samples : 见那些大哥哥还在～地说话，她也听不出味道，就打了两个哈欠，悄悄溜了出来。 ★欧阳山《三家巷》九
     */

    private String id;
    private String name;
    private String spell;
    private String content;
    private String derivation;
    private String samples;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDerivation() {
        return derivation;
    }

    public void setDerivation(String derivation) {
        this.derivation = derivation;
    }

    public String getSamples() {
        return samples;
    }

    public void setSamples(String samples) {
        this.samples = samples;
    }
}
