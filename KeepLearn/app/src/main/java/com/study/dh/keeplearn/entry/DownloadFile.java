package com.study.dh.keeplearn.entry;

import java.util.List;

/**
 * Created by dh on 2017/2/16.
 */

public class DownloadFile {

    /**
     * code : 200
     * quantity : 92
     * digitCodes : [{"digitCode":"310514","mealerCode":"8349140142375336"},{"digitCode":"284559","mealerCode":"8349140142567886"},{"digitCode":"692099","mealerCode":"8349140142712705"},{"digitCode":"568296","mealerCode":"8349140142360917"},{"digitCode":"664760","mealerCode":"8349140142356619"},{"digitCode":"416007","mealerCode":"8349140142486630"},{"digitCode":"732155","mealerCode":"8349140142610994"},{"digitCode":"747874","mealerCode":"8349140142470444"},{"digitCode":"912711","mealerCode":"8349140142614913"},{"digitCode":"180109","mealerCode":"8349140142468570"},{"digitCode":"948207","mealerCode":"8349140142386100"},{"digitCode":"339648","mealerCode":"8349140142527510"},{"digitCode":"657813","mealerCode":"8349140142381775"},{"digitCode":"382911","mealerCode":"8349140142807045"},{"digitCode":"784738","mealerCode":"8349140142629106"},{"digitCode":"461676","mealerCode":"8349140142320893"},{"digitCode":"729408","mealerCode":"8349140142940627"},{"digitCode":"980110","mealerCode":"8349140142363027"},{"digitCode":"382329","mealerCode":"8349140142495104"},{"digitCode":"843175","mealerCode":"8349140142904606"},{"digitCode":"295063","mealerCode":"8349140142373004"},{"digitCode":"521533","mealerCode":"8349140142973445"},{"digitCode":"866229","mealerCode":"8349140142365082"},{"digitCode":"993726","mealerCode":"8349140142734209"},{"digitCode":"493208","mealerCode":"8349140142394960"},{"digitCode":"328599","mealerCode":"8349140143041022"},{"digitCode":"248543","mealerCode":"8349140143154021"},{"digitCode":"305430","mealerCode":"8349140142617045"},{"digitCode":"629095","mealerCode":"8349140142464632"},{"digitCode":"383471","mealerCode":"8349140142523457"},{"digitCode":"360869","mealerCode":"8349140142460597"},{"digitCode":"171479","mealerCode":"8349140142689471"},{"digitCode":"668352","mealerCode":"8349140143151112"},{"digitCode":"942984","mealerCode":"8349140143190898"},{"digitCode":"506196","mealerCode":"8349140142613039"},{"digitCode":"710437","mealerCode":"8349140142573671"},{"digitCode":"441072","mealerCode":"8349140142342338"},{"digitCode":"268002","mealerCode":"8349140142530587"},{"digitCode":"573894","mealerCode":"8349140142717054"},{"digitCode":"729408","mealerCode":"8349140142863080"},{"digitCode":"284995","mealerCode":"8349140142525566"},{"digitCode":"902713","mealerCode":"8349140142488670"},{"digitCode":"968551","mealerCode":"8349140142452620"},{"digitCode":"908828","mealerCode":"8349140142462619"},{"digitCode":"359974","mealerCode":"8349140142582142"},{"digitCode":"906639","mealerCode":"8349140143045257"},{"digitCode":"451250","mealerCode":"8349140142669972"},{"digitCode":"266958","mealerCode":"8349140142497073"},{"digitCode":"324137","mealerCode":"8349140142946756"},{"digitCode":"292981","mealerCode":"8349140142515067"},{"digitCode":"339648","mealerCode":"8349140142528419"},{"digitCode":"219323","mealerCode":"8349140143064975"},{"digitCode":"742827","mealerCode":"8349140142350374"},{"digitCode":"702783","mealerCode":"8349140142944691"},{"digitCode":"642123","mealerCode":"8349140142894864"},{"digitCode":"870946","mealerCode":"8349140142761730"},{"digitCode":"702783","mealerCode":"8349140142633540"},{"digitCode":"265998","mealerCode":"8349140142441030"},{"digitCode":"875978","mealerCode":"8349140143083722"},{"digitCode":"183706","mealerCode":"8349140143200395"},{"digitCode":"969268","mealerCode":"8349140142388223"},{"digitCode":"142273","mealerCode":"8349140142856827"},{"digitCode":"163318","mealerCode":"8349140142997031"},{"digitCode":"406727","mealerCode":"8349140142575769"},{"digitCode":"947402","mealerCode":"8349140143148324"},{"digitCode":"273546","mealerCode":"8349140142644941"},{"digitCode":"846859","mealerCode":"8349140142367247"},{"digitCode":"617825","mealerCode":"8349140142421539"},{"digitCode":"241307","mealerCode":"8349140142399132"},{"digitCode":"266958","mealerCode":"8349140142397031"},{"digitCode":"498745","mealerCode":"8349140142887326"},{"digitCode":"373263","mealerCode":"8349140142794539"},{"digitCode":"413747","mealerCode":"8349140142454530"},{"digitCode":"621345","mealerCode":"8349140143181556"},{"digitCode":"143633","mealerCode":"8349140142415606"},{"digitCode":"180109","mealerCode":"8349140142729454"},{"digitCode":"814353","mealerCode":"8349140142433937"},{"digitCode":"504217","mealerCode":"8349140142339992"},{"digitCode":"261399","mealerCode":"8349140142521457"},{"digitCode":"252564","mealerCode":"8349140143196921"},{"digitCode":"835276","mealerCode":"8349140142598530"},{"digitCode":"334424","mealerCode":"8349140142874620"},{"digitCode":"265998","mealerCode":"8349140142442000"},{"digitCode":"912711","mealerCode":"8349140142504500"},{"digitCode":"793150","mealerCode":"8349140143161252"},{"digitCode":"100315","mealerCode":"8349140142493073"},{"digitCode":"590534","mealerCode":"8349140143058674"},{"digitCode":"657595","mealerCode":"8349140142534961"},{"digitCode":"784738","mealerCode":"8349140142547795"},{"digitCode":"188937","mealerCode":"8349140142423506"},{"digitCode":"513442","mealerCode":"8349140142510897"},{"digitCode":"687652","mealerCode":"8349140142692491"}]
     * message : 成功
     */

    private int code;
    private int quantity;
    private String message;
    /**
     * digitCode : 310514
     * mealerCode : 8349140142375336
     */

    private List<DigitCodesBean> digitCodes;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DigitCodesBean> getDigitCodes() {
        return digitCodes;
    }

    public void setDigitCodes(List<DigitCodesBean> digitCodes) {
        this.digitCodes = digitCodes;
    }

    public static class DigitCodesBean {
        private String digitCode;
        private String mealerCode;

        public String getDigitCode() {
            return digitCode;
        }

        public void setDigitCode(String digitCode) {
            this.digitCode = digitCode;
        }

        public String getMealerCode() {
            return mealerCode;
        }

        public void setMealerCode(String mealerCode) {
            this.mealerCode = mealerCode;
        }
    }
}
