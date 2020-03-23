package org.redapps.statelistread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
    private SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HashMap<String, String> item;    //Used to link data to lines
        //Load the data
        for (String[] aStates_Capitals_Population : States_Capitals_Population) {
            item = new HashMap<String, String>();
            item.put("line1", aStates_Capitals_Population[0]);
            item.put("line2", aStates_Capitals_Population[1]);
            item.put("line3", aStates_Capitals_Population[2]);
            list.add(item);
        }
        //Use an Adapter to link data to Views
        simpleAdapter = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c});
        //Link the Adapter to the list
        ((ListView) findViewById(R.id.list)).setAdapter(simpleAdapter);
        ((ListView) findViewById(R.id.list)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                String str = "Selected:\n" + States_Capitals_Population[position][0] + "\n" +
                        States_Capitals_Population[position][1] + "\n" +
                        States_Capitals_Population[position][2] + "\n";
                //By position in array
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
            }
        });
    }

    //Data
    private String[][] States_Capitals_Population =
            {{"Alabama", "Montgomery", "4,833,722"},
                    {"Alaska", "Juneau", "735,132"},
                    {"Arizona", "Phoenix", "6,626,624"},
                    {"Arkansas", "Little Rock", "2,959,373"},
                    {"California", "Sacramento", "38,332,521"},
                    {"Colorado", "Denver", "5,268,367"},
                    {"Connecticut", "Hartford", "3,596,080"},
                    {"Delaware", "Dover", "925,749"},
                    {"Florida", "Tallahassee", "19,552,860"},
                    {"Georgia", "Atlanta", "9,992,167"},
                    {"Hawaii", "Honolulu", "1,404,054"},
                    {"Idaho", "Boise", "1,612,136"},
                    {"Illinois", "Springfield", "12,882,135"},
                    {"Indiana", "Indianapolis", "6,570,902"},
                    {"Iowa", "Des Moines", "3,090,416"},
                    {"Kansas", "Topeka", "2,893,957"},
                    {"Kentucky", "Frankfort", "4,395,295"},
                    {"Louisiana", "Baton Rouge", "4,625,470"},
                    {"Maine", "Augusta", "1,328,302"},
                    {"Maryland", "Annapolis", "5,928,814"},
                    {"Massachusetts", "Boston", "6,692,824"},
                    {"Michigan", "Lansing", "9,895,622"},
                    {"Minnesota", "St. Paul", "5,420,380"},
                    {"Mississippi", "Jackson", "2,991,207"},
                    {"Missouri", "Jefferson City", "6,044,171"},
                    {"Montana", "Helena", "1,015,165"},
                    {"Nebraska", "Lincoln", "1,868,516"},
                    {"Nevada", "Carson", "City", "2,790,136"},
                    {"New Hampshire", "Concord", "1,323,459"},
                    {"New Jersey", "Trenton", "8,899,339"},
                    {"New Mexico", "Santa Fe", "2,085,287"},
                    {"New York", "Albany", "19,651,127"},
                    {"North Carolina", "Raleigh", "9,848,060"},
                    {"North Dakota", "Bismarck", "723,393"},
                    {"Ohio", "Columbus", "11,570,808"},
                    {"Oklahoma", "Oklahoma City", "3,850,568"},
                    {"Oregon", "Salem", "3,930,065"},
                    {"Pennsylvania", "Harrisburg", "12,773,801"},
                    {"Rhode Island", "Providence", "1,051,511"},
                    {"South Carolina", "Columbia", "4,774,839"},
                    {"South Dakota", "Pierre", "844,877"},
                    {"Tennessee", "Nashville", "6,495,978"},
                    {"Texas", "Austin", "26,448,193"},
                    {"Utah", "Salt Lake City", "2,900,872"},
                    {"Vermont", "Montpelier", "626,630"},
                    {"Virginia", "Richmond", "8,260,405"},
                    {"Washington", "Olympia", "6,971,406"},
                    {"West Virginia", "Charleston", "1,854,304"},
                    {"Wisconsin", "Madison", "5,742,713"},
                    {"Wyoming", "Cheyenne", "582,658"}};
}
