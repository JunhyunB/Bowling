package com.example.junhyun.perfectgame;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import  org.apache.commons.lang3.ArrayUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class touch_main extends AppCompatActivity {

    double _600_32[][] = new double[600][32];


    double _32_32[][] = {{-0.034100793,-0.22779459,0.25494593,-0.13107163,0.016662253,0.07109707,-0.06008644,0.31243405,0.0924617,0.11587882,-0.25589287,-0.12676343,0.1856021,0.028792208,0.23757854,-0.2949124,0.006780086,-0.21777512,0.05329766,0.047515813,-0.14671932,0.27980185,0.22719684,0.27123398,-0.19079214,-0.06523269,0.06323561,-0.05958718,-0.2535609,-0.029610293,-0.074821375,-0.16104253},
            {0.059283733,0.2950673,-0.039638914,0.052976325,-0.027098276,0.009507088,0.2953898,0.103191674,0.21632737,-0.007535694,0.16873947,-0.10569281,0.043329068,0.22956872,-0.20169675,0.13372685,0.23257141,0.27008265,-0.21091741,-0.15620261,0.23977657,0.036176674,0.2272146,-0.27262008,0.18541318,-0.16462998,0.22745636,0.2572485,0.19074444,-0.27168605,-0.21934378,0.08667699},
            {0.28603205,0.26867464,-0.29171854,0.11762554,0.19036318,0.015781619,-0.292896,0.08475427,0.10559999,-0.13006584,0.042311344,-0.20668703,-0.17142393,0.050009757,-0.034540832,-0.16219828,0.21536323,-0.15552126,0.08723614,0.21454076,0.18614309,-0.16360086,-0.18462169,0.07788398,-0.10303197,0.10170864,-0.26601103,-0.06778209,0.09388818,-0.20996012,-0.00550112,0.26778835},
            {-0.076434724,0.09624599,-0.2288105,0.21591513,-0.22930934,-0.106599405,-0.2008955,-0.081938185,-0.3098096,0.15213656,-0.033866424,0.27794704,-0.020640628,0.20466046,-0.0048307,-0.2019577,0.084272385,0.039903883,0.08298218,-0.056312613,0.18280126,0.27882975,0.19621953,-0.075243466,-0.16854475,-0.2652099,0.1406255,-0.21905981,-0.027656002,0.22250485,-0.20553073,0.10877418},
            {-0.17777474,0.025563825,-0.20434879,0.06332384,-0.2858136,0.14710099,0.08790345,0.2608509,-0.117055036,0.25517598,-0.13798183,0.079973675,-0.17930536,-0.00556527,0.048888985,0.09987262,-0.017306203,0.13712372,-0.16465169,-0.103057496,-0.3006738,-0.050310634,0.18921733,0.140182,-0.08925194,0.2721702,-0.21066624,0.2185442,0.09119758,-0.09998051,0.20829196,0.2505901},
            {0.33319408,0.28263703,-0.10184825,0.05546125,-0.21400821,-0.034845375,-0.003020372,-0.124049924,0.0244165,0.1875209,0.07486653,0.12510066,0.28418034,0.10732481,-0.2862109,-0.10098474,0.10527793,0.27055848,-0.2065362,-0.077943556,0.18663436,-0.06897956,-0.19131766,-0.32472983,-0.09699506,-0.15059157,-0.21759985,-0.25708383,-0.109077685,-0.20320378,-0.07155733,0.010439477},
            {-0.14575447,-0.2652097,0.2026749,0.2830511,-0.2580075,-0.13919684,0.06655084,-0.22958712,0.06480311,-0.23091938,-0.07463386,0.025712274,0.18591316,0.25872687,-0.263548,-0.0741036,-0.06296427,0.11837864,0.008379691,0.057816647,0.13703084,-0.18383378,-0.042621072,-0.30967584,-0.17495689,0.19363412,-0.077093534,0.28693104,0.0013646284,-0.2807355,-0.08320994,-0.22515668},
            {-0.070740476,0.2195369,-0.2088087,0.033288255,-0.03628945,0.06625292,-0.2770254,0.022080988,-0.10159666,-0.04063196,-0.2476948,0.16796418,0.01975973,0.1746781,-0.19295192,0.27898687,0.26436958,-0.17506266,-0.21495894,-0.29492497,-0.31742063,-0.09476993,-0.19658463,0.06038324,-0.22599016,-0.13160121,-0.15106133,-0.13918847,0.3048911,0.118162885,0.14749861,0.042375408},
            {-0.13909942,-0.19803497,-0.051161893,0.2641078,0.24376066,-0.13609356,0.077893235,-0.20336528,0.18426366,0.297107,0.2674598,0.067527674,0.20471077,-0.0029032188,-0.09802392,0.19085258,0.20374735,-0.15947866,0.25156754,-0.19107985,-0.074349344,0.22767863,0.09244945,0.27987516,0.1988691,-0.15570903,-0.26424223,-0.28121814,0.03264218,-0.09485379,-0.032155003,-0.12796217},
            {0.13282073,-0.17927524,0.23281266,-0.24436814,-0.017648939,0.1671544,-0.22013585,-0.15490916,0.12557459,0.07595899,-0.016243568,0.1112096,0.24147165,-0.039428644,-0.06740862,0.05435052,0.33068073,-0.008793213,0.27277437,0.16690762,0.13591626,-0.10639996,-0.23621617,0.26705882,-0.13459267,-0.18281238,-0.13400891,0.2297243,0.18508898,-0.029284758,-0.15378347,0.069383465},
            {-0.17547736,0.05123562,0.06277903,0.25227526,0.15254611,0.08740735,0.28109226,0.10639487,-0.08368789,0.10160514,-0.047952186,-0.17329916,0.02649961,0.055647306,-0.035289925,0.079418175,-0.27480203,0.013295906,-0.0481931,0.2498001,0.14906041,0.09438025,-0.18246801,0.18446958,0.21873905,-0.10245854,-0.14830324,0.10260071,-0.036561184,-0.027015213,-0.21840166,0.1387401},
            {0.17648022,0.20776416,0.16599785,-0.22947356,0.09904936,-0.07564103,-0.28526244,-0.123356186,0.1310918,-0.10698365,-0.13300376,0.27342167,-0.20761472,0.09683774,-0.04769364,-0.24561723,0.2884023,0.0432304,-0.08794909,-0.11274381,0.25730512,-0.16876452,0.07515273,-0.24818538,-0.1284565,0.032700352,-0.09373351,0.28782713,0.14852321,-0.22207633,0.1275425,-0.025546351},
            {-0.19481847,0.26993617,0.22153789,0.024697801,-0.02361853,-0.31418133,-0.16533427,0.321967,0.11156601,0.054144703,-0.01435285,0.21567446,-0.046662565,0.25866285,0.28916404,0.17335138,0.10084852,0.032997333,-0.29048863,-0.15709236,0.14467287,-0.015665041,-0.06464663,-0.011129945,0.3361751,0.2620395,0.2859582,-0.1785553,-0.050762642,0.023094673,-0.15181518,0.048728332},
            {-0.18853326,-0.07224254,0.11715462,0.27637678,-0.0701855,0.15920001,-0.11843858,0.086773224,-0.32360876,0.06761416,0.17824031,0.16854776,0.069957234,0.17536494,-0.21112128,0.21191551,-0.15623546,-0.1386847,0.009331308,-0.054012667,-0.14161538,-0.15905558,0.19473875,0.053734902,0.2518664,-0.13659021,0.19684996,0.21481223,-0.21447518,-0.16540524,-0.24239005,-0.22426891},
            {-0.21912691,0.117779285,-0.20760337,0.08702085,0.06717471,0.06223655,-0.28303966,0.116768554,-0.117577724,-0.098349616,0.3118326,0.24043952,0.25436977,0.29366404,-0.29893464,-0.09714589,-0.0847707,-0.0036352195,0.16429114,-0.043875467,0.12054745,-0.057741266,-0.1259516,-0.21510042,-0.08781539,0.07997171,-0.2021597,-0.20245978,0.25142643,-0.1279552,-0.32291827,-0.15094778},
            {0.024621211,-0.14419545,-0.23601446,0.017148878,-0.18858963,0.19340917,0.2628318,0.00964582,-0.16136216,-0.13519439,0.16576174,-0.24985199,-0.095891684,-0.10548985,-0.22082615,0.23942702,-0.20851572,-0.06724125,0.013522476,-0.28847203,-0.22878069,-0.0616615,0.121897064,-0.11845187,0.20971824,0.25616083,-0.14300624,-0.2839745,0.1968779,-0.20956768,0.19461879,0.052082375},
            {0.017762125,0.1173536,-0.24940564,-0.16188611,0.07817274,-0.16622816,0.08435104,0.23026481,-0.3127812,-0.21410428,0.0465908,-0.198425,0.19142868,-0.22175957,-0.19534154,-0.25498506,0.023949476,-0.2511193,0.010342177,0.036916833,0.02091487,-0.31443495,0.0017567157,-0.23394665,0.33244208,-0.18829937,0.16393307,-0.04073997,-0.22607861,0.018314606,-0.28189516,0.09341344},
            {-0.1863465,-0.044928357,-0.041096237,-0.10445683,0.0667508,-0.06824821,-0.110169165,0.23976868,-0.065406576,-0.11649486,0.040364802,0.022966279,0.09324154,0.16506882,-0.07586421,0.24563102,0.14043935,0.14198682,-0.18274768,0.17095986,0.22643676,-0.10588738,-0.20792489,0.12589386,0.34970257,-0.11322065,0.07020308,0.18470521,-0.13846593,0.0001281503,0.047800377,-0.063837156},
            {-0.102120884,-0.20240894,-0.2526772,-0.259501,-0.103843704,0.069451235,0.17813897,-0.15681523,0.22214319,-0.27616757,0.060162567,0.24910125,0.307126,0.01584477,-0.29733288,-0.13566618,0.26347527,-0.26285976,0.038698364,0.095230155,0.14066878,-0.22569723,0.006320037,-0.119677536,-0.1388934,-0.0902728,-0.26600364,-0.13963196,0.166219,0.09770362,0.21319008,0.07782645},
            {-0.0155238435,0.32652885,0.051095817,0.068772726,0.116917476,-0.15652604,0.14869827,-0.092810765,0.09762424,0.18565342,-0.11486212,-0.1563093,-0.10230221,0.280933,0.13241825,-0.16929272,0.1527743,-0.26848525,0.16598502,-0.2543722,0.028479245,0.10385151,-0.29863688,-0.23775475,0.20814605,0.2266081,0.24567477,-0.008708514,-0.22016156,0.14552209,0.22922514,0.10674394},
            {0.19360256,0.24772519,0.26359028,0.065881066,0.17154428,0.22009084,0.2755232,-0.138474,-0.16889177,0.01661779,-0.22747894,0.28130072,0.010704053,0.15265593,-0.059539028,0.085892014,-0.12883258,-0.27835688,-0.29965442,0.1552136,0.053816475,-0.16275845,-0.15114102,0.011590804,0.14821212,0.05891554,0.12126385,-0.08906441,-0.12922549,0.23103318,0.118539006,-0.06422256},
            {-0.029490855,0.12840049,0.109183796,0.15255608,-0.18241623,0.06571204,-0.18519299,-0.18005976,-0.21448655,0.15208825,-0.23318738,-0.06505703,0.29288328,0.27883327,-0.0006522756,-0.30999362,-0.13008264,-0.12469977,0.24561106,-0.19092642,0.24146056,-0.1302275,0.039550994,0.23332812,0.18104358,0.027186824,0.21599676,-0.14718153,0.03981925,-0.16397683,-0.12994163,0.044786017},
            {0.061396714,0.15457214,-0.21952346,-0.024761591,-0.16113654,-0.07357273,-0.30366683,-0.22911179,0.10145052,-0.08142172,0.12324736,0.3437055,0.12435762,-0.036113404,0.22223674,-0.15708289,-0.11211659,0.15660273,0.094175875,0.124214396,-0.17305544,0.28423414,-0.2703766,0.13183573,0.25229332,0.011413165,0.064957306,-0.25087532,-0.110646024,0.11389374,0.09745237,0.16373259},
            {-0.0018224914,-0.25796527,-0.059167806,0.008253566,0.07260759,0.20089497,0.21161166,-0.031439792,-0.23132853,-0.043600433,0.04230846,0.3398933,0.119520724,-0.25670415,-0.079382814,-0.28520152,-0.14184675,-0.19262934,0.2440854,-0.16118525,0.09391527,-0.1828679,0.034605194,-0.04192005,0.29915515,-0.29976487,-0.17058344,-0.095447615,0.1893041,0.15438911,-0.16633013,-0.18832335},
            {-0.024806835,0.09995821,0.16847368,-0.21068996,-0.25936577,0.18838608,-0.21043517,-0.18864559,-0.30362818,-0.26044023,-0.24403517,-0.22502233,-0.06544117,0.085323885,-0.025869163,0.044398226,-0.084586434,-0.17583619,-0.045050535,-0.23532028,-0.020289332,-0.289464,-0.12542316,-0.1713934,-0.1475043,-0.24351124,0.18134867,0.20591299,-0.20893635,-0.014609053,0.15887201,0.16157895},
            {0.07459564,0.03789682,-0.18326828,0.05915634,-0.29653415,0.2415853,-0.2728747,0.34245,-0.1386847,0.23766106,-0.063850336,-0.14191893,0.21745166,-0.24971175,0.10791303,-0.006263496,-0.030012136,0.2031968,0.02605448,0.2445395,-0.27903593,-0.15343301,0.073404185,0.2634752,-0.043739833,-0.24528256,-0.25401604,-0.19930282,-0.008972892,-0.11095527,-0.31256223,-0.31907296},
            {0.15420148,0.16142744,-0.23691726,-0.11142561,-0.21645594,-0.15291134,-0.019486519,0.200347,0.14158776,0.18565156,0.13149956,0.12226879,0.23312265,-0.06689173,-0.20410447,-0.09492977,0.080442645,0.15422392,0.12688193,-0.0313939,0.08122224,0.15378332,0.0322778,-0.18863805,-0.21662149,0.17083244,0.29058963,0.26797357,-0.2041185,-0.013923488,0.26388538,-0.1304378},
            {-0.19866002,-0.20484906,-0.11979515,0.19504443,0.11512636,0.07273627,-0.21104865,0.14986259,-0.208825,0.15152565,-0.0054016565,-0.100452416,-0.21270642,-0.26656404,0.20537105,-0.13211867,-0.19690928,0.05808755,0.07616264,-0.23819074,0.16060463,-0.016011342,-0.13724682,-0.31534615,-0.06496771,-0.16075188,0.20624988,-0.19305515,-0.075534545,-0.25177374,-0.15377508,0.20391865},
            {0.14190455,0.004923367,-0.16807728,0.14718418,0.20948814,-0.22049849,0.008335159,0.11223044,0.03508382,-0.112636305,-0.24322745,-0.22650242,0.19210084,0.109314695,-0.09727018,0.030993095,0.09846579,0.23375961,0.1740982,0.016304627,-0.10907269,0.17740336,-0.109758504,-0.18678428,0.2725487,-0.2501328,0.18818922,-0.3121107,0.19290045,-0.23658001,0.23142575,0.15526307},
            {-0.0042202687,0.110136494,0.12039278,0.085139506,0.055509076,-0.28995416,0.32045984,-0.25484502,0.24943453,-0.17330247,-0.2433741,0.2339539,-0.09075262,0.032992724,0.22940099,0.298419,-0.24350783,0.23008601,-0.15436259,0.24811172,0.063576005,-0.26942992,0.21309777,-0.15232468,-0.07335469,-0.2555274,-0.075784676,0.03459872,0.20708057,-0.04006377,0.19506218,0.01129871},
            {-0.099863246,0.33037198,-0.27360532,0.02171436,-0.2881257,-0.27220598,-0.287304,-0.05710974,-0.20519745,-0.08747604,-0.016746769,-0.14566422,0.22610612,-0.23915143,-0.1803815,0.123592064,-0.27299988,-0.2990964,0.20076507,-0.07151824,-0.05905086,0.063621506,-0.11451182,-0.12545334,-0.14260472,-0.28239828,0.091194674,-0.07327125,0.0027348348,-0.22306748,0.013384065,-0.22473037},
            {0.004249098,0.096777104,0.19594191,-0.2690121,-0.15136857,0.18311383,-0.28929833,0.05790976,0.059826016,0.077277,-0.16287121,0.11744301,-0.014670389,0.117145896,0.21543647,-0.20057803,0.0582779,0.006956397,0.16282783,0.21255045,0.2185858,-0.19837382,-0.2799882,-0.18649544,-0.20718893,-0.19270676,0.23466025,0.08071368,-0.038008012,0.17822573,0.018482843,0.054725736}};
    double _32_4[][] = {{0.22277823,0.13188276,-0.15889606,0.41535068},
            {0.39751107,0.22893703,-0.051653307,-0.025729714},
            {-0.13507804,0.16998541,-0.05884449,-0.35690245},
            {0.026200127,-0.14211653,0.055946995,0.27459362},
            {0.21354096,0.38927498,-0.3590219,0.177424},
            {-0.10268362,-0.17709878,-0.06962048,0.38602668},
            {0.097808555,0.087652676,-0.17353763,0.3242515},
            {-0.09146235,-0.34060892,0.14900346,0.4042766},
            {-0.31046182,-0.2618874,-0.37804312,-0.084700264},
            {0.03064649,-0.014693339,0.0030116923,0.16716406},
            {0.22598328,0.20450814,0.3254984,-0.21067806},
            {0.062643014,-0.27032635,-0.044175476,0.39892587},
            {0.21745162,0.2874267,0.0790917,0.39813983},
            {-0.25349343,0.34836295,0.41402534,0.32265282},
            {0.20444222,-0.19250102,0.026260985,0.062107686},
            {0.2582499,0.09831883,-0.22178283,-0.09185118},
            {0.4572601,0.35340947,0.27834865,-0.22465664},
            {-0.22029856,-0.22133149,-0.14792925,-0.2031591},
            {0.30433568,0.12087641,-0.34453714,0.35028866},
            {0.011228866,0.0691205,-0.27423176,-0.07061771},
            {0.21562287,-0.22912812,-0.2735926,-0.30689958},
            {0.40492287,0.29336497,-0.34414452,-0.0005305187},
            {0.35386282,-0.21455467,-0.3271672,-0.18424745},
            {-0.13588904,0.013616325,-0.19950193,-0.12051951},
            {0.13348286,0.0037095037,0.19164237,-0.19762622},
            {-0.0010883567,0.20174778,-0.027382562,-0.2119497},
            {-0.06255156,-0.1828922,0.27786803,-0.19572908},
            {0.049693253,0.38654634,-0.35995653,0.13445188},
            {0.41828117,0.33086067,-0.06348419,0.10863719},
            {-0.23522225,-0.24125402,0.15474628,0.39137623},
            {-0.12236954,0.09594829,-0.17110799,0.23008986},
            {-0.0888577,-0.36191347,-0.30283108,-0.36075357}};
    double bias1[][] = {{-0.019983318,0.03394608,-0.012332746,0.024453506,-0.014531591,0.017145064,-0.002041855,0.015718533,0.027258916,0.0059381654,-0.009411035,-0.012163195,0.025527805,0.03335375,0.027655542,-0.013191182,0.03340493,0.008068442,-0.0023247402,-0.0012801089,0.02523769,0.022532402,0.04219583,0.03287956,-0.019264063,0.018324295,0.03333135,-0.01432762,0.0236754,-0.011521356,0.016961195,-0.011633374}};
    double bias2[][] ={{0.031462483,0.033029165,-0.012634964,0.037607003,-0.015373539,0.004403776,0.001076082,0.038650505,-0.017579637,0.029745005,0.03622178,0.04101783,0.025627296,0.004144649,0.02896441,-0.012932101,0.033097655,-0.024179785,0.009648319,-0.018609015,-0.015231207,-0.009226229,-0.012642686,-0.018125271,0.037458967,-0.009319205,0.029717796,-0.012747149,0.028733596,-0.007435517,-0.018394167,-0.012543812}};
    double bias3[][] = {{0.033746008,-0.02962858,0.03325384,0.026992058}};


    String TAG;

    SoundPool soundpool;
    int sound;
    ArrayList x_result = new ArrayList<Float>();
    ArrayList y_result = new ArrayList<Float>();

    ArrayList<Float> x_acc = new ArrayList<Float>();
    ArrayList<Float> y_acc = new ArrayList<Float>();
    ArrayList<Float> z_acc = new ArrayList<Float>();

    ArrayList<Float> x_gyro = new ArrayList<Float>();
    ArrayList<Float> y_gyro = new ArrayList<Float>();
    ArrayList<Float> z_gyro = new ArrayList<Float>();

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private Sensor mMagneticField;
    private Sensor mGgyroSensor = null;
    private SensorEventListener mAccelLis;
    private SensorEventListener mMagLis;
    private SensorEventListener mGyroLis;

    private double RAD2DGR = 180 / Math.PI;
    private static final float NS2S = 1.0f/1000000000.0f;
    private float mAzimut;
    //private float mPitch;
    //private float mRoll;
    double gyroX;
    double gyroY;
    double gyroZ;
    ArrayList mPitch = new ArrayList<Float>(); //각속도만 어레이로 받았음
    ArrayList mRoll = new ArrayList<Float>();
    private TextView mResultView;

    float[] mGravity;
    float[] mGeomagnetic;

    int i = 0;
    public double[][] matplus(double[][] A, double[][] B) {
        int A_row = A.length;
        int A_columns = A[0].length;
        double[][] C = new double[A_row][A_columns];
        for (int i = 0; i < A_row; i++) {
            for (int j = 0; j < A_columns; j++) {
                C[i][j] = A[i][j]+B[i][j];
            }
        }
        return C;
    }

    public double[][] matmul(double[][] A, double[][] B) {

        int A_row = A.length;
        int A_columns = A[0].length;
        int B_rows = B.length;
        int B_columns = B[0].length;

        if (A_columns != B_rows) {
            throw new IllegalArgumentException("A:Rows: " + A_columns + " did not match B:Columns " + B_rows + ".");
        }

        double[][] C = new double[A_row][B_columns];
        for (int i = 0; i < A_row; i++) {
            for (int j = 0; j < B_columns; j++) {
                C[i][j] = 0.00000;
            }
        }

        for (int i = 0; i < A_row; i++) {
            for (int j = 0; j < B_columns; j++) {
                for (int k = 0; k < A_columns; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }
    public double[][] relu(double[][] A){
        double[][] C = new double[A.length][A[0].length];
        for(int i = 0; i<A.length; i++){
            for(int j = 0; j<A[0].length; j++){
                if(0<A[i][j]) C[i][j] = A[i][j];
                else C[i][j] = 0;
            }
        }
        return C;
    }

    public double[] prediction(double[][] input){
        Log.d(TAG,"예측 시작");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("_600_32.txt"), "UTF-8"));

            // do reading, usually loop until end of file reading
            String mLine;

            int k = 0;
            while ((mLine = reader.readLine()) != null) {
                mLine = mLine.substring(1,mLine.length()-2);
                String[] array;
                array = mLine.split(",");
                double Line[] = new double[array.length];
                int i =0;
                for(String num : array){
                    Line[i] = Double.parseDouble(num);
                    i+=1;
                }_600_32[k] = Line;
                k+=1;



            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }

        double[][] hidden1 = relu(matplus(matmul(input, _600_32),bias1));
        double[][] hidden2 = relu(matplus(matmul(hidden1, _32_32),bias2));
        double[][] output = relu(matplus(matmul(hidden2, _32_4),bias3));

        Log.d(TAG,"예측 완료");
        return output[0];
    }

    public double[][] preprocess(){
        int x_acc_len = x_acc.size();
        int y_acc_len = y_acc.size();
        int z_acc_len = z_acc.size();
        int x_gyro_len = x_gyro.size();
        int y_gyro_len = y_gyro.size();
        int z_gyro_len = z_gyro.size();
        float[] x_acc_array = ArrayUtils.toPrimitive(x_acc.toArray(new Float[0]), 0.0F);
        float[] y_acc_array = ArrayUtils.toPrimitive(y_acc.toArray(new Float[0]), 0.0F);
        float[] z_acc_array = ArrayUtils.toPrimitive(z_acc.toArray(new Float[0]), 0.0F);
        float[] x_gyro_array = ArrayUtils.toPrimitive(x_gyro.toArray(new Float[0]), 0.0F);
        float[] y_gyro_array = ArrayUtils.toPrimitive(y_gyro.toArray(new Float[0]), 0.0F);
        float[] z_gyro_array = ArrayUtils.toPrimitive(z_gyro.toArray(new Float[0]), 0.0F);


        double[][] C = new double[1][600];
        for(int i=0; i<100; i ++){
            if(x_acc_len-100+i<0) C[0][i] = 0;
            else
                C[0][i] = (x_acc_array[x_acc_len-100+i]+6.88842439)/7.6877898;
        }
        for(int i=0; i<100; i ++){
            if(y_acc_len-100+i<0) C[0][i] = 0;
            else
                C[0][i+100] = (y_acc_array[y_acc_len-100+i]+2.06951539)/6.00646138;
        }
        for(int i=0; i<100; i ++){
            if(z_acc_len-100+i<0) C[0][i] = 0;
            else
                C[0][i+200] = (z_acc_array[z_acc_len-100+i]-1.78368688)/4.27854944;
        }
        for(int i=0; i<100; i ++){
            if(x_gyro_len-100+i<0) C[0][i] = 0;
            else
                C[0][i+300] = (x_gyro_array[x_gyro_len-100+i]+0.22509693)/2.27363739;
        }
        for(int i=0; i<100; i ++){
            if(y_gyro_len-100+i<0) C[0][i] = 0;
            else
                C[0][i+400] = (y_gyro_array[y_gyro_len-100+i]-0.16980954)/1.29598639;
        }
        for(int i=0; i<100; i ++){
            if(z_gyro_len-100+i<0) C[0][i] = 0;
            else
                C[0][i+500] = (z_gyro_array[z_gyro_len-100+i]+0.1736662)/1.82796134;
        }

        Log.d(TAG,"프리프로세스 완료");
        return C;
    }

    public List physics(float mass, float theta,
                        float x_vel, float y_vel,
                        float x_ang, float y_ang) {

        float radius = 0.1085F; // [kg]
        float g = 9.8F; // [m/s^2]
        float I = 2 / 5 * mass * radius * radius; // Inertia of sphere
        float u_k = 0.2F; // friction coeff.
        float t = 0.01F; // time slice = 0.01 [sec]
        float x_position = 0;
        float y_position = 0;
        float PI = 3.141592F;
        double angle = theta * PI / 180;
        float crit1 = 0.0F;
        float crit2 = 0.0F;
        int count = 0;
        int count2 = 0;

        mass = 0.453592F * mass; // 파운드 변환


        ArrayList x = new ArrayList<Float>();
        x.add(x_position);

        ArrayList y = new ArrayList<Float>();
        y.add(y_position);


        for(int i=0; i<400; i++){
            count = i;
            crit1 = x_vel - 0.5F*g*t*(i+1);
            crit2 = x_vel - radius*x_ang;

            if (crit1<0) {
                break;
            }

            x_position = x_position + x_vel*t;
            x.add(x_position);

            x_ang = x_ang + (radius*u_k*mass*g*t) / I;

        }
        count2 = count;
        for(int j=0; j<400-count; j++){
            count2 = count2 + 1;
            crit2 = x_vel - radius*x_ang;

            if (crit2>0) {
                break;
            }

            x_position = x_position + x_vel*t + 0.5F*u_k*g*t*t;

            x.add(x_position);

            x_vel = x_vel + u_k*g*t;

        }

        for(int k=0; k<400-count2;k++){
            x_position = x_position + x_vel*t;
            x.add(x_position);
        }

        //System.out.println(x.size());

        // calculate y_position
        for(int i=0; i<400; i++){
            count = i;
            crit1 = y_vel - 0.5F*g*t*(i+1);
            crit2 = y_vel - radius*y_ang;

            if (crit1<0) {
                break;
            }

            y_position = y_position + y_vel*t;
            y.add(y_position);

            y_ang = y_ang + (radius*u_k*mass*g*t) / I;

        }
        count2 = count;
        for(int j=0; j<400-count; j++){
            count2 = count2 + 1;
            crit2 = y_vel - radius*y_ang;

            if (crit2>0) {
                break;
            }

            y_position = y_position + y_vel*t + 0.5F*u_k*g*t*t;

            y.add(y_position);

            y_vel = y_vel + u_k*g*t;

        }

        for(int k=0; k<400-count2;k++){
            y_position = y_position + y_vel*t;
            y.add(y_position);
        }

        ArrayList x_ = new ArrayList<Float>();
        ArrayList y_ = new ArrayList<Float>();

        float x__;
        float y__;
        float cos = (float)Math.cos(angle);
        float sin = (float)Math.sin(angle);

        for(int i=0; i<y.size(); i++){
            x__ = cos * (float) x.get(i) + sin * (float) y.get(i);
            y__ = -1 * sin * (float) x.get(i) + cos * (float) y.get(i);

            x_.add(x__);
            y_.add(y__);
        }
        List tempList = new ArrayList();
        tempList.add(x_);
        tempList.add(y_);

        return tempList;
    }



    @Override
    protected void onCreate(Bundle savedInstanceStace) {
        super.onCreate(savedInstanceStace);
        setContentView(R.layout.activity_touch_main);

        Intent intent = getIntent();
        final float mass = intent.getExtras().getFloat("mass");
        int gamecheck = intent.getExtras().getInt("gamecheck"); // swing practice 와 mini game 을 구분해야함.

        ImageView B1 = (ImageView) findViewById(R.id.touchB1);
        ImageView B2 = (ImageView) findViewById(R.id.touchB2);
        final Animation alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);

        B1.startAnimation(alpha);
        B2.startAnimation(alpha);

        mResultView = (TextView) findViewById(R.id.textView2);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mAccelLis = new SenserListener();
        mMagneticField = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mMagLis = new SenserListener();
        mGgyroSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        mGyroLis = new SenserListener();

        soundpool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        sound = soundpool.load(this, R.raw.sound1, 1);
        soundpool.play(sound, 1, 1, 0, 1, 1);

        ImageButton button2 = (ImageButton) findViewById(R.id.touchB1);


        button2.setOnTouchListener(new View.OnTouchListener()      {
            //int i=0; //어레이실패

            SenserListener SL = new SenserListener();
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        break;

                    case MotionEvent.ACTION_MOVE:
                        //SL.onSensorChanged(); // 이건 뭐지?
                        mSensorManager.registerListener(mAccelLis ,mAccelerometer, SensorManager.SENSOR_DELAY_UI);
                        mSensorManager.registerListener(mMagLis, mMagneticField, SensorManager.SENSOR_DELAY_UI);
                        mSensorManager.registerListener(mGyroLis, mGgyroSensor, SensorManager.SENSOR_DELAY_UI);
                        String result;
                        result = "Azimut:"+mAzimut+"\n"+"Pitch:"+mPitch+"\n"+"Roll:"+mRoll+"\n"+"gyroX:"+gyroX+"\n"+"gyroY:"+gyroY+"\n"+"gyroZ:"+gyroZ+"\n";
                        //result = "Azimut:"+mAzimut+"\n"+"Pitch:"+mPitch.get(i)+"\n"+"Roll:"+mRoll.get(i); //이 부분이 어레이로 받아서 시도했는데 안되는 부분이에요 ㅠ
                        mResultView.setText(result);

                        //i++; //어레이 실패
                        break;

                    case MotionEvent.ACTION_UP:
                        i+=1;

                        double[] predicts = prediction(preprocess());

                        x_acc = new ArrayList<Float>();
                        y_acc = new ArrayList<Float>();
                        z_acc = new ArrayList<Float>();

                        x_gyro = new ArrayList<Float>();
                        y_gyro = new ArrayList<Float>();
                        z_gyro = new ArrayList<Float>();

                        List L = physics(mass, 8, (float)predicts[0], (float)predicts[1]/4, (float)predicts[2], (float)predicts[3]);
                        //List L = physics(12, 0, 7, 0, 0, 0);

                        x_result = (ArrayList<Float>)L.get(0);
                        y_result = (ArrayList<Float>)L.get(1);
                        Intent intent = new Intent(getApplicationContext(), lane.class);
                        Bundle b = new Bundle();
                        b.putParcelableArrayList("x_result", x_result);
                        b.putParcelableArrayList("y_result", y_result);
                        intent.putExtra("bundle", b);
                        startActivity(intent);
                        break;

                    default:
                        break;
                }

                return false;
            }

        });
    }
    /* //지워야하는가.....
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mMagneticField, SensorManager.SENSOR_DELAY_NORMAL);
    }
*/
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(mAccelLis);
    }

    private class SenserListener implements SensorEventListener {
        @Override
        public void onSensorChanged(SensorEvent event) {


            if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {

                /*
                gyroX = event.values[0];
                gyroY = event.values[1];
                gyroZ = event.values[2];


                dt = (event.timestamp - timestamp) * NS2S;
                timestamp = event.timestamp;

                if (dt - timestamp*NS2S != 0) {
                    // 각속도 성분을 적분 -> 회전각(pitch, roll)으로 변환.
                    pitch = pitch + gyroY*dt;
                    roll = roll + gyroX*dt;
                    yaw = yaw + gyroZ*dt;
                }
                */

                x_gyro.add(event.values[0]); //자이로 XYZ 받아오는 변수들입니다
                y_gyro.add(event.values[1]);
                z_gyro.add(event.values[2]);
            }

            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {//가속도 센서 감지
                //mGravity = event.values;
                x_acc.add(event.values[0]);
                y_acc.add(event.values[1]);
                z_acc.add(event.values[2]);

            }

            if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) //지자기 센서 감지
                mGeomagnetic = event.values;

            if (mGravity != null && mGeomagnetic != null) { //가속도와 지자기센서
                float R[] = new float[9];
                float I[] = new float[9];
                boolean success = SensorManager.getRotationMatrix(R, I, mGravity, mGeomagnetic);
                if (success) {
                    float orientation[] = new float[3];
                    SensorManager.getOrientation(R, orientation);
                    mAzimut = (float) Math.toDegrees(orientation[0]); //방위각 추가
                    mPitch.add((float) Math.toDegrees(orientation[1])); //pitch List에 추가
                    mRoll.add((float) Math.toDegrees(orientation[2])); //roll List에 추가
                    //mPitch = (float) Math.toDegrees(orientation[1]);
                    //mRoll = (float) Math.toDegrees(orientation[2]);
                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }

    class Background extends Thread {
        @Override
        public void run() {
            super.run();
            // Thread code 작성하기.
        }
    }
}