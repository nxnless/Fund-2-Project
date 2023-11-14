package Home;

import Player.Entity;

public class CollisonCheck {
    GPanel Pan ;

    public CollisonCheck(GPanel Pan)
    {
        this.Pan = Pan;
    }

    public void CheckBox(Entity Enty){

        int EntityLeftX = Enty.PlayerX + Enty.SolidPlayer.x;
        int EntityRightX = Enty.PlayerX + Enty.SolidPlayer.x +Enty.SolidPlayer.width;

        int EntityTopY = Enty.PlayerY + Enty.SolidPlayer.y;
        int EntityBotY = Enty.PlayerY + Enty.SolidPlayer.y +Enty.SolidPlayer.height;

        
        //หาว่าตำแหน่งนั้นเป็นบล็อคอะไร
        int EntyLeftCol = EntityLeftX/48; //หารขนาดของบล็อคเพราะจะหาว่าตำแหน่งของบล็อคนนั้นอยู่ตรงไหนในขนาด ORIGIN
        int EntyRightCol = EntityRightX/48;

        int EntyTopRow = EntityTopY/48;
        int EntyBotRow = EntityBotY/48;

        int BoxNum1,BoxNum2; //ต้องการเช็ค 2 บล็อคในเวลาเดียวกัน

        switch(Enty.Direction)
        {
            case 1: //Up
                EntyTopRow = (EntityTopY - Enty.Speed)/48; 
                BoxNum1 = Pan.BoxM.MapBoxNumber[EntyLeftCol][EntyTopRow];
                BoxNum2 = Pan.BoxM.MapBoxNumber[EntyRightCol][EntyTopRow];
                if(Pan.BoxM.box[BoxNum1].BoxColli == true || Pan.BoxM.box[BoxNum2].BoxColli == true)
                {
                    Enty.OnCollison = true;
                }
                break;
            case 2 ://Down
                EntyBotRow = (EntityBotY + Enty.Speed)/48; 
                BoxNum1 = Pan.BoxM.MapBoxNumber[EntyLeftCol][EntyBotRow];
                BoxNum2 = Pan.BoxM.MapBoxNumber[EntyRightCol][EntyBotRow];
                if(Pan.BoxM.box[BoxNum1].BoxColli == true || Pan.BoxM.box[BoxNum2].BoxColli == true)
                {
                    Enty.OnCollison = true;
                }
                break;

            case 3://Left
                EntyLeftCol = (EntityLeftX - Enty.Speed)/48; 
                BoxNum1 = Pan.BoxM.MapBoxNumber[EntyLeftCol][EntyTopRow];
                BoxNum2 = Pan.BoxM.MapBoxNumber[EntyLeftCol][EntyBotRow];
                if(Pan.BoxM.box[BoxNum1].BoxColli == true || Pan.BoxM.box[BoxNum2].BoxColli == true)
                {
                    Enty.OnCollison = true;
                }
                break;

            case 4://Right
                EntyRightCol = (EntityRightX + Enty.Speed)/48; 
                BoxNum1 = Pan.BoxM.MapBoxNumber[EntyRightCol][EntyTopRow];
                BoxNum2 = Pan.BoxM.MapBoxNumber[EntyRightCol][EntyBotRow];
                if(Pan.BoxM.box[BoxNum1].BoxColli == true || Pan.BoxM.box[BoxNum2].BoxColli == true)
                {
                    Enty.OnCollison = true;
                }
                break;
        }

    }
}
