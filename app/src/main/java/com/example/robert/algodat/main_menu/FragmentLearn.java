        package com.example.robert.algodat.main_menu;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.GridView;
        import android.net.Uri;

        import com.example.robert.algodat.R;


public class FragmentLearn extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public FragmentLearn() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FragmentLearn newInstance(int sectionNumber) {
        FragmentLearn fragment = new FragmentLearn();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_menu_fragment_learn, container, false);

        String[] textLearn = {"Algorithms", "Data Structures", "Vectors", "Lists", "Trees", "Graphs"};

        //iconsLearn for ListView (order dependent on locationOrder)
        int iconsLearn[] = {R.mipmap.ic_learn01, R.mipmap.ic_learn02,
                R.mipmap.ic_learn03, R.mipmap.ic_learn04,
                R.mipmap.ic_learn05, R.mipmap.ic_learn06
        };


        //assign GridView
        GridView locationGridView = (GridView)rootView.findViewById(R.id.gridView);


        locationGridView.setAdapter(new CustomAdapter(getActivity(), textLearn, iconsLearn));


        locationGridView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent;
                        switch (position){
                            // Algorithmen
                            case 0:
                                Uri uriUrl0 = Uri.parse("https://drive.google.com/open?id=0B8XCsolbXnxHc0ExSGxCUk5mNkU");
                                Intent launchBrowser0 = new Intent(Intent.ACTION_VIEW, uriUrl0);
                                startActivity(launchBrowser0);
                                break;
                            // Datenstrukturen
                            case 1:
                                Uri uriUrl1 = Uri.parse("https://drive.google.com/open?id=0B8XCsolbXnxHZ1FWcjdTN28tQk0");
                                Intent launchBrowser1 = new Intent(Intent.ACTION_VIEW, uriUrl1);
                                startActivity(launchBrowser1);
                                break;
                            // Vektoren
                            case 2:
                                Uri uriUrl2 = Uri.parse("https://drive.google.com/open?id=0B8XCsolbXnxHSVdrcDlUWTdMT0U");
                                Intent launchBrowser2 = new Intent(Intent.ACTION_VIEW, uriUrl2);
                                startActivity(launchBrowser2);
                                break;
                            // Listen
                            case 3:
                                Uri uriUrl3 = Uri.parse("https://drive.google.com/open?id=0B8XCsolbXnxHbkdqb3VBbllDdXc");
                                Intent launchBrowser3 = new Intent(Intent.ACTION_VIEW, uriUrl3);
                                startActivity(launchBrowser3);
                                break;
                            // Bäume
                            case 4:
                                Uri uriUrl4 = Uri.parse("https://drive.google.com/open?id=0B8XCsolbXnxHZkd3WHpxMncySEE");
                                Intent launchBrowser4 = new Intent(Intent.ACTION_VIEW, uriUrl4);
                                startActivity(launchBrowser4);
                                break;
                            // Graphen
                            case 5:
                                Uri uriUrl5 = Uri.parse("https://drive.google.com/open?id=0B8XCsolbXnxHWmVPdV9RbERtLWc");
                                Intent launchBrowser5 = new Intent(Intent.ACTION_VIEW, uriUrl5);
                                startActivity(launchBrowser5);
                                break;
                            default:
                        }


                    }
                }
        );

        return rootView;
    }
}