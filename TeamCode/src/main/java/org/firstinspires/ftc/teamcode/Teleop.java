package org.firstinspires.ftc.teamcode;

import com.github.pmtischler.control.Mecanum;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Teleop mode.
 */
@TeleOp(name="TeamCode.Teleop", group="TeamCode")
public class Teleop extends OpMode {

    /**
     * Initializes the robot.
     * Called once before the match when the "Init" button is pressed.
     */
    public void init() {
        leftFrontMotor = hardwareMap.dcMotor.get("leftFrontMotor");
        rightFrontMotor = hardwareMap.dcMotor.get("rightFrontMotor");
        leftBackMotor = hardwareMap.dcMotor.get("leftBackMotor");
        rightBackMotor = hardwareMap.dcMotor.get("rightBackMotor");

        // TODO: Initialize other motors and servos.
    }

    /**
     * Main loop function.
     * Called repeatedly during the match after the "Play" button is pressed.
     */
    public void loop() {
        // Convert joysticks to desired motion.
        if(!gamepad1.right_bumper) {
            rightFrontMotor.setPower(-gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x);
            leftFrontMotor.setPower(gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x);
            rightBackMotor.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x);
            leftBackMotor.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x);
        }
        else
            rightFrontMotor.setPower(0.5 * (-gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x));
            leftFrontMotor.setPower(0.5 * (gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x));
            rightBackMotor.setPower(0.5 * (-gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x));
            leftBackMotor.setPower(0.5 * (gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x));

        // TODO: Add rest of robot teleop control.
    }



    /**
     * Stops the robot.
     * Called once at the end of the match when time runs out.
     */
    public void stop() {
        // Stop all drive motors.
        leftFrontMotor.setPower(0);
        rightFrontMotor.setPower(0);
        leftBackMotor.setPower(0);
        rightBackMotor.setPower(0);

        // TODO: Add any other stop behavior.
    }

    // The drive motors (front, back; left, right).
    private DcMotor leftFrontMotor;
    private DcMotor rightFrontMotor;
    private DcMotor leftBackMotor;
    private DcMotor rightBackMotor;
}
