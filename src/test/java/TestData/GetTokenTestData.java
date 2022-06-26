package TestData;

import java.util.HashMap;
import java.util.Map;

public class GetTokenTestData {



    public Map<String, String> reqTestDataBody(){

        HashMap<String, String> expectedMap = new HashMap<>();
        expectedMap.put("merchant_code","20625123425");
        expectedMap.put("password","a1a82a55-8355-46f1-9a95-3cd9adce495b");

        return expectedMap;

    }
}
