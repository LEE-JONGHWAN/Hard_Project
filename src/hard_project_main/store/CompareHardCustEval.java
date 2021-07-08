package hard_project_main.store;

import java.util.Comparator;

public class CompareHardCustEval implements Comparator<HardProduct>  {

		@Override
		public int compare(HardProduct hard1, HardProduct hard2) {
			return Float.compare(hard2.get고객평점(), hard1.get고객평점());
	}
}
