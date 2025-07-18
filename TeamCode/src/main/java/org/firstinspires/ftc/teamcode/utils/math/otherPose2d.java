//package org.firstinspires.ftc.teamcode.utils;
//
//import android.annotation.SuppressLint;
//
//import androidx.annotation.NonNull;
//
//public class otherPose2d implements Cloneable {
//        public double x;
//        public double y;
//        public double heading;
//
//        public otherPose2d(double x, double y) {
//                this(x, y, 0);
//        }
//
//        public otherPose2d(double x, double y, double heading) {
//                this.x = x;
//                this.y = y;
//                this.heading = heading;
//        }
//
//        public void add(otherPose2d p1) {
//                this.x += p1.x;
//                this.y += p1.y;
//                this.heading += p1.heading;
//        }
//
//        public boolean isNaN() {
//                return Double.isNaN(x) || Double.isNaN(y) || Double.isNaN(heading);
//        }
//
//        public double getX() {
//                return x;
//        }
//
//        public double getY() {
//                return y;
//        }
//
//        public double getHeading() {
//                return heading;
//        }
//
//        public double getDistanceFromPoint(otherPose2d newPoint) { // distance equation
//                return Math.sqrt(Math.pow((x - newPoint.x), 2) + Math.pow((y - newPoint.y), 2));
//        }
//
//        public double getErrorInX(otherPose2d newPoint) { // distance equation
//                return Math.abs(x - newPoint.x);
//        }
//
//        public double getErrorInY(otherPose2d newPoint) { // distance equation
//                return Math.abs(y - newPoint.y);
//        }
//
//        public void clipAngle() {
//                heading = AngleUtil.clipAngle(heading);
//        }
//
//        public Vector3 toVec3() {
//                return new Vector3(x, y, heading * Globals.ROBOT_WIDTH / 2);
//        }
//
//        @NonNull
//        @Override
//        public otherPose2d clone() {
//                return new otherPose2d(x, y, heading);
//        }
//
//        @SuppressLint("DefaultLocale")
//        public String toString() {
//                return String.format("(%.3f, %.3f, %.3f", x, y, heading);
//        }
//}