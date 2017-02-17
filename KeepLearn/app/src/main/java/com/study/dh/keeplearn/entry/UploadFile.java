package com.study.dh.keeplearn.entry;

import java.util.List;

/**
 * Created by dh on 2017/2/16.
 */

public class UploadFile {


    /**
     * boxId : SZ-B10024
     * mealers : [{"index":"1:1","mealerCode":"8349140142692491"},{"index":"1:2","mealerCode":"8349140142527510"},{"index":"1:3","mealerCode":"8349140142689471"},{"index":"1:4","mealerCode":"8349140143041022"},{"index":"1:5","mealerCode":"8349140142904606"},{"index":"1:6","mealerCode":"8349140142887326"},{"index":"1:7","mealerCode":"8349140142856827"},{"index":"1:8","mealerCode":"8349140142573671"},{"index":"1:11","mealerCode":"8349140142798683"},{"index":"1:12","mealerCode":"8349140142339992"},{"index":"2:1","mealerCode":"8349140143190898"},{"index":"2:2","mealerCode":"8349140143196921"},{"index":"2:3","mealerCode":"8349140142360917"},{"index":"2:4","mealerCode":"8349140142614913"},{"index":"2:5","mealerCode":"8349140143058674"},{"index":"2:6","mealerCode":"8349140142547795"},{"index":"2:7","mealerCode":"8349140142807045"},{"index":"2:8","mealerCode":"8349140142373004"},{"index":"2:11","mealerCode":"8349140142442000"},{"index":"2:12","mealerCode":"8349140142433937"},{"index":"3:1","mealerCode":"8349140142441030"},{"index":"3:2","mealerCode":"8349140142421539"},{"index":"3:3","mealerCode":"8349140142367247"},{"index":"3:4","mealerCode":"8349140142350374"},{"index":"3:5","mealerCode":"8349140142567886"},{"index":"3:6","mealerCode":"8349140142729454"},{"index":"3:7","mealerCode":"8349140142497073"},{"index":"3:8","mealerCode":"8349140142894864"},{"index":"3:9","mealerCode":"8349140142452620"},{"index":"3:10","mealerCode":"8349140142761730"},{"index":"3:11","mealerCode":"8349140143200395"},{"index":"3:12","mealerCode":"8349140143181556"},{"index":"4:1","mealerCode":"8349140142734209"},{"index":"4:2","mealerCode":"8349140142598530"},{"index":"4:3","mealerCode":"8349140142575769"},{"index":"4:4","mealerCode":"8349140142320893"},{"index":"4:5","mealerCode":"8349140142528419"},{"index":"4:6","mealerCode":"8349140142669972"},{"index":"4:7","mealerCode":"8349140142794539"},{"index":"4:8","mealerCode":"8349140142633540"},{"index":"4:9","mealerCode":"8349140143064975"},{"index":"4:10","mealerCode":"8349140142521457"},{"index":"4:11","mealerCode":"8349140142381775"},{"index":"4:12","mealerCode":"8349140142394960"},{"index":"5:1","mealerCode":"8349140142530587"},{"index":"5:2","mealerCode":"8349140143045257"},{"index":"5:3","mealerCode":"8349140142997031"},{"index":"5:4","mealerCode":"8349140142946756"},{"index":"5:5","mealerCode":"8349140143151112"},{"index":"5:6","mealerCode":"8349140142582142"},{"index":"5:7","mealerCode":"8349140142510897"},{"index":"5:8","mealerCode":"8349140143154021"},{"index":"5:9","mealerCode":"8349140143148324"},{"index":"5:10","mealerCode":"8349140142397031"},{"index":"5:11","mealerCode":"8349140142629106"},{"index":"5:12","mealerCode":"8349140142940627"},{"index":"6:1","mealerCode":"8349140142717054"},{"index":"6:2","mealerCode":"8349140142464632"},{"index":"6:3","mealerCode":"8349140142462619"},{"index":"6:4","mealerCode":"8349140142610994"},{"index":"6:5","mealerCode":"8349140142973445"},{"index":"6:6","mealerCode":"8349140143161252"},{"index":"6:7","mealerCode":"8349140142525566"},{"index":"6:8","mealerCode":"8349140142470444"},{"index":"6:9","mealerCode":"8349140142495104"},{"index":"6:10","mealerCode":"8349140142523457"},{"index":"6:11","mealerCode":"8349140142388223"},{"index":"6:12","mealerCode":"8349140142515067"},{"index":"7:1","mealerCode":"8349140142944691"},{"index":"7:2","mealerCode":"8349140142363027"},{"index":"7:3","mealerCode":"8349140142454530"},{"index":"7:4","mealerCode":"8349140142613039"},{"index":"7:5","mealerCode":"8349140142423506"},{"index":"7:6","mealerCode":"8349140142644941"},{"index":"7:7","mealerCode":"8349140142375336"},{"index":"7:8","mealerCode":"8349140142493073"},{"index":"7:9","mealerCode":"8349140142415606"},{"index":"7:10","mealerCode":"8349140142874620"},{"index":"7:11","mealerCode":"8349140142534961"},{"index":"7:12","mealerCode":"8349140142365082"},{"index":"8:1","mealerCode":"8349140142486630"},{"index":"8:2","mealerCode":"8349140142342338"},{"index":"8:3","mealerCode":"8349140142468570"},{"index":"8:4","mealerCode":"8349140142488670"},{"index":"8:5","mealerCode":"8349140142504500"},{"index":"8:6","mealerCode":"8349140142617045"},{"index":"8:7","mealerCode":"8349140143083722"},{"index":"8:8","mealerCode":"8349140142386100"},{"index":"8:9","mealerCode":"8349140142712705"},{"index":"8:10","mealerCode":"8349140142863080"},{"index":"8:11","mealerCode":"8349140142399132"},{"index":"8:12","mealerCode":"8349140142356619"},{"index":"9:1","mealerCode":"8349140142460597"}]
     * timestamp : 1487200661
     * quantity : 93
     */

    private String boxId;
    private int timestamp;
    private int quantity;
    /**
     * index : 1:1
     * mealerCode : 8349140142692491
     */

    private List<MealersBean> mealers;

    public String getBoxId() {
        return boxId;
    }

    public void setBoxId(String boxId) {
        this.boxId = boxId;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<MealersBean> getMealers() {
        return mealers;
    }

    public void setMealers(List<MealersBean> mealers) {
        this.mealers = mealers;
    }

    public static class MealersBean {
        private String index;
        private String mealerCode;

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getMealerCode() {
            return mealerCode;
        }

        public void setMealerCode(String mealerCode) {
            this.mealerCode = mealerCode;
        }
    }
}
