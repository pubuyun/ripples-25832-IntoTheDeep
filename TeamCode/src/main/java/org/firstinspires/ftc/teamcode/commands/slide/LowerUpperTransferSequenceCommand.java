package org.firstinspires.ftc.teamcode.commands.slide;

import org.firstinspires.ftc.teamcode.commands.base.ActionCommand;
import org.firstinspires.ftc.teamcode.commands.base.ConditionalCommand;
import org.firstinspires.ftc.teamcode.commands.base.SequentialCommandGroup;
import org.firstinspires.ftc.teamcode.commands.base.WaitCommand;
import org.firstinspires.ftc.teamcode.utils.control.ConfigVariables;

import java.util.function.BooleanSupplier;

/**
 * Command for the lower+upper slide transfer sequence (auto/teleop)
 */
public class LowerUpperTransferSequenceCommand extends SequentialCommandGroup {
        public LowerUpperTransferSequenceCommand(LowerSlideCommands lowerSlideCommands,
                                                 UpperSlideCommands upperSlideCommands) {
                this(lowerSlideCommands, upperSlideCommands, () -> true);
        }

        public LowerUpperTransferSequenceCommand(LowerSlideCommands lowerSlideCommands,
                                                 UpperSlideCommands upperSlideCommands,
                                                 BooleanSupplier catched) {
                super();

                addCommands(
                        // Step 0: slidePos2
                        new ActionCommand(upperSlideCommands.closeExtendoClaw()),
                        new ActionCommand(lowerSlideCommands.slidePos2()),
                        new ActionCommand(upperSlideCommands.openClaw()),
                        // Step 1: Wait then up
//                        new WaitCommand(ConfigVariables.AutoTesting.D_SLIDEPOS0AFTERDELAY_S),
                        new ActionCommand(lowerSlideCommands.up()),
                        new ActionCommand(upperSlideCommands.scorespec()),

                        // Step 2: Wait then transfer
                        new WaitCommand(ConfigVariables.AutoTesting.E_LOWSLIDEUPAFTERDELAY_S),
                        // if color sensor not detected, move to pos1(inner)
//                        new ConditionalCommand(
//                                () -> !catched.getAsBoolean(),
//                                new ActionCommand(lowerSlideCommands.slidePos1())
//                        ),
//                        new ConditionalCommand(
//                                () -> !catched.getAsBoolean(),
//                                new WaitCommand(0.3)
//                        ),
                        new ActionCommand(upperSlideCommands.transfer()),

                        // Step 3: Wait then closeClaw
                        new WaitCommand(ConfigVariables.AutoTesting.F_TRANSFERAFTERDELAY_S),
                        new ActionCommand(upperSlideCommands.closeClaw()),

                        // Step 4: Wait then openClaw
                        new WaitCommand(ConfigVariables.AutoTesting.G_LOWSLIDETRANSFEROPENCLAWAFTERDELAY_S),
                        new ActionCommand(lowerSlideCommands.openClaw())
                );
        }
}