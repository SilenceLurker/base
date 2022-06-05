package xyz.silencelurker.hw.base.entity.factory;

import xyz.silencelurker.hw.base.entity.Occupation;

/**
 * @author Silence_Lurker
 */
public class OccupationFactory {
    private int occupationId = -1;
    private String occupation = "";
    private Occupation o;

    public void setOccupation(String occupation) {
        o.setOccupation(occupation);
    }

    public void setOccupationId(int occupationId) {
        o.setOccupationId(occupationId);
    }

    public Occupation build() {
        o = new Occupation();

        if (occupationId == -1) {
            occupationId = 0;
        }

        if ("".equals(occupation)) {
            occupation = "未命名";
        }

        o.setOccupation(occupation);
        o.setOccupationId(occupationId);
        return o;
    }

}
