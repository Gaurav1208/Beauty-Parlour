package com.example.beautyparlour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class ServicesFragment extends Fragment implements View.OnClickListener {

    View view;
    private CardView Threading,Forehead,UpperLip,LowerLip,ChinThread,FaceThreadSide,NoseThread,FullFaceThread,MassageFacial,ShehnazFacial,LotusFacial,MassageCleanUp,ScrubCleanUp,NormalCleanUp,BrandedCleanUp,WineCleanUp,CTM,WhiteningCleanUp,GelCleanUp;
    private CardView ShaAlmond,ShaThermo,ShaInstant,ShaPower,ShaGold,ShaDiamond,ShaAnti,ShaWhitening,FruitSaladFacial,HoneyAlmondFacial,PapayaFacial,BananaBoost,FairnessFacial,GoldVitalFacial,DiamondPolishingFacial,SilverHealingFacial,DvineFacial,WineFacial,PlatinumFacial,ChocolateFacial,WrinkledFacial;
    private CardView BlossomSkinGlow,BlossomBridalGlow,BlossomThermo,BlossomBamboo,BlossomSignature,BlossomPearl,BlossomSilver,BlossomGold,BlossomDiamond,BlossomVitaminC,BlossomPowerMask;
    private CardView WhiteningFacial,MeladeamDTan,DiamondPolishing,GoldPolishing,TimeExpertFacial,PowerMask,NormalCleanup,DTanCleanUp,TimeExpertCleanUp,FruitBleech,HaldiChandanBleech,NatureGoldBleech,DiamondBleech,PerfectWhiteningBleech,DTanSaraBleech,FemFairnessBleech,FemTurmericBleech,OxyLifeBleech,FemPearlBleech,FemGoldBleech,OzoneDtan,OzoneVitaminC;
    private CardView NeckBleech,NeckBleechDtan,ArmsBleech,ArmsDtan,FullBodyBleech,FullBodyDtan,BodyPolishing;
    private CardView UpperLipWax,LowerLipWax,ForeheadWax,ChinWax,SideWax,NoseWax,FullFaceWax,UnderArmsWax,NeckWax,LegsWax,FootWax,HalfLegsWax,BackWax,TummyWax,FullBodyWax,FullBackWax,HalfBackWax;
    private CardView ManicurePadicure,ManicurePadicureLotus,ManicurePadicureLotusSpa,HydraSpaCreme,DeepSmootheningCreme,SerumHairSpa;
    private CardView LorealHairColour,LorealHairColourFullTouch,LorealHairColourFull,BlonderPerStreak,ColouredStreak,AromaOilMassage,Rebounding,HairPedrm,SpiralPedrm,HennaColour;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_services,null);



        return view;
    }

    @Override
    public void onClick(View v) {

    }
}