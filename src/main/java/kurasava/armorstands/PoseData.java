package kurasava.armorstands;
import org.bukkit.util.EulerAngle;

public class PoseData {

    public boolean hasArms;
    public EulerAngle head;
    public EulerAngle body;
    public EulerAngle leftLeg;
    public EulerAngle rightLeg;
    public EulerAngle leftArm;
    public EulerAngle rightArm;

    public PoseData(boolean hasArms,
                    EulerAngle head, EulerAngle body, EulerAngle leftLeg,
                    EulerAngle rightLeg, EulerAngle leftArm, EulerAngle rightArm) {
        this.hasArms = hasArms;
        this.head = head;
        this.body = body;
        this.leftLeg = leftLeg;
        this.rightLeg = rightLeg;
        this.leftArm = leftArm;
        this.rightArm = rightArm;
    }
}
