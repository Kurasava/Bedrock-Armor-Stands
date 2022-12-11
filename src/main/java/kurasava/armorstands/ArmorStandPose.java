package kurasava.armorstands;
import kurasava.Main;
import org.bukkit.entity.ArmorStand;
import org.bukkit.util.EulerAngle;
import java.util.ArrayList;

public class ArmorStandPose {

    private static ArrayList<PoseData> poses;
    private static Utils utils;

    public ArmorStandPose() {
        utils = new Utils();
        poses = new ArrayList<>();
        this.initPose();
    }

    //Установка позы при ПКМ в соответствии с индексом
    public void applyPoseRightClick( ArmorStand armorStand, int poseIndex) {
        if (poseIndex >= 0 && poseIndex < poses.size()) {
            PoseData poseData = poses.get(poseIndex);
            armorStand.setArms(poseData.hasArms);
            armorStand.setHeadPose(poseData.head);
            armorStand.setBodyPose(poseData.body);
            armorStand.setLeftLegPose(poseData.leftLeg);
            armorStand.setRightLegPose(poseData.rightLeg);
            armorStand.setLeftArmPose(poseData.leftArm);
            armorStand.setRightArmPose(poseData.rightArm);
            int index = utils.getPoseIndex(armorStand);
            if (index == 14) {
                index = -2;
            }
            utils.setPoseIndex(armorStand, index + 1);
        }
    }
    //Установка позы редстоуном в соответствии с индексом
    public void applyPoseRedstone(final ArmorStand armorStand, int poseIndex) {
        if (poseIndex >= 0 && poseIndex < poses.size()) {
            PoseData poseData = poses.get(poseIndex);
            armorStand.setArms(poseData.hasArms);
            armorStand.setHeadPose(poseData.head);
            armorStand.setBodyPose(poseData.body);
            armorStand.setLeftLegPose(poseData.leftLeg);
            armorStand.setRightLegPose(poseData.rightLeg);
            armorStand.setLeftArmPose(poseData.leftArm);
            armorStand.setRightArmPose(poseData.rightArm);
            utils.setPoseIndex(armorStand, poseIndex);
        }
    }
    //Добавление поз в ArrayList
    private void initPose() {
        poses.add(new PoseData(false, EulerAngle.ZERO,
                EulerAngle.ZERO,
                EulerAngle.ZERO,
                EulerAngle.ZERO,
                EulerAngle.ZERO,
                EulerAngle.ZERO));
        poses.add(new PoseData(true, EulerAngle.ZERO,
                EulerAngle.ZERO,
                EulerAngle.ZERO,
                EulerAngle.ZERO,
                EulerAngle.ZERO,
                EulerAngle.ZERO));
        poses.add(new PoseData(true, new EulerAngle(-0.174533, 0.132665, 0.0261799),
                new EulerAngle(0.08472, 0.0372665, 0.0261799),
                new EulerAngle(0.0749066, -0.01253, -0.144533),
                new EulerAngle(-0.0549066, 0.02237, 0.084533),
                new EulerAngle(0.61799, 0.0, -0.51799),
                new EulerAngle(-2.0944, 0.73421, 0.0)));
        poses.add(new PoseData(true, new EulerAngle(0.214533, 0.09, 0.0),
                new EulerAngle(0.0, 0.0, 0.0),
                new EulerAngle(0.0, 0.0, 0.0),
                new EulerAngle(0.0, 0.0, 0.0),
                new EulerAngle(-0.81799, 0.0, 0.51799),
                new EulerAngle(4.4855, 6.28319, 1.0821)));
        poses.add(new PoseData(true, new EulerAngle(0.0, 0.0, 0.0),
                new EulerAngle(0.0, 0.0, 0.0),
                new EulerAngle(0.0, 0.0, 0.0),
                new EulerAngle(0.0, 0.0, 0.0),
                new EulerAngle(5.63741, 5.81195, 0.0),
                new EulerAngle(5.63741, 0.575959, 0.0)));
        poses.add(new PoseData(true, new EulerAngle(6.17847, 0.244346, 0.0),
                new EulerAngle(0.0, 0.0, 0.0),
                new EulerAngle(0.0, 0.0, 0.0),
                new EulerAngle(0.0, 0.0, 0.0),
                new EulerAngle(0.0, 0.0, 6.14356),
                new EulerAngle(5.06145, 0.20944, 0.174533)));
        poses.add(new PoseData(true, new EulerAngle(6.03884, 0.0, 0.0),
                new EulerAngle(0.0, 0.0, 0.0),
                new EulerAngle(0.0, 0.0, 6.17847),
                new EulerAngle(0.0, 0.0, 0.10472),
                new EulerAngle(4.32842, 0.610865, 0.0),
                new EulerAngle(4.32842, 5.67232, 0.0)));
        poses.add(new PoseData(true, new EulerAngle(6.17847, 0.0, 0.0),
                new EulerAngle(0.0, 0.0, 0.0),
                new EulerAngle(0.0, 0.0, 6.14356),
                new EulerAngle(0.0, 0.0, 0.10472),
                new EulerAngle(4.36332, 5.74213, 0.0),
                new EulerAngle(4.36332, 0.610865, 0.0)));
        poses.add(new PoseData(true, new EulerAngle(6.17847, 0.0, 0.0),
                new EulerAngle(0.0, 0.0, 0.0),
                new EulerAngle(0.0, 0.0, 6.14356),
                new EulerAngle(0.0, 0.0, 0.10472),
                new EulerAngle(0.0, 0.0, 6.00393),
                new EulerAngle(5.23599, 5.16617, 0.0)));
        poses.add(new PoseData(true, new EulerAngle(0.139626, 0.506145, 0.0),
                new EulerAngle(0.0, 0.0, 0.0),
                new EulerAngle(5.95157, 0.0, 6.00393),
                new EulerAngle(0.0, 0.0, 0.10472),
                new EulerAngle(3.38594, 0.0, 1.0821),
                new EulerAngle(4.72984, 5.63741, 5.5676)));
        poses.add(new PoseData(true, new EulerAngle(6.07375, 6.21337, 0.0),
                new EulerAngle(0.0, 0.0, 0.0),
                new EulerAngle(5.95157, 0.0, 6.00393),
                new EulerAngle(5.60251, 0.0, 0.0),
                new EulerAngle(4.59022, 0.0, 0.0),
                new EulerAngle(4.79966, 0.0, 0.0)));
        poses.add(new PoseData(true, new EulerAngle(6.07375, 6.21337, 0.0),
                new EulerAngle(0.0, 0.0, 0.0),
                new EulerAngle(4.11898, 0.506145, 0.0),
                new EulerAngle(0.0, 0.471239, 6.10865),
                new EulerAngle(2.89725, 0.0, 0.680678),
                new EulerAngle(3.31613, 0.0, 5.53269)));
        poses.add(new PoseData(true, new EulerAngle(6.07375, 6.21337, 0.0),
                new EulerAngle(0.0, 0.0, 0.0),
                new EulerAngle(0.174533, 4.45059, 0.0),
                new EulerAngle(4.15388, 5.84685, 6.28319),
                new EulerAngle(3.28122, 0.0, 0.680678),
                new EulerAngle(2.93215, 0.0, 5.53269)));
        poses.add(new PoseData(true, new EulerAngle(0.0, 0.0, 0.0),
                new EulerAngle(0.0, 0.0, 0.0),
                new EulerAngle(4.39823, 0.471239, 0.0),
                new EulerAngle(4.59022, 5.84685, 6.28319),
                new EulerAngle(3.28122, 0.0, 0.680678),
                new EulerAngle(2.93215, 0.0, 5.53269)));
        poses.add(new PoseData(true, new EulerAngle(6.21337, 1.18682, 0.0),
                new EulerAngle(0.0, 0.0, 0.0),
                new EulerAngle(0.0, 0.0, 6.10865),
                new EulerAngle(0.0, 0.0, 0.174533),
                new EulerAngle(0.0, 0.0, 6.03884),
                new EulerAngle(4.55531, 1.15192, 0.0)));
        poses.add(new PoseData(true, new EulerAngle(6.24828, 0.506145, 0.0),
                new EulerAngle(0.0, 0.0, 0.0),
                new EulerAngle(0.0, 0.0, 6.10865),
                new EulerAngle(0.0, 0.0, 0.174533),
                new EulerAngle(0.10472, 0.0, 6.21337),
                new EulerAngle(4.15388, 0.610865, 0.0)));
    }
}
