#include<iostream>
#include<new>
class trie_node
{
public:
    int is_a_leaf;
	char c;
    trie_node* children[26];
    trie_node()
    {
	//std::cout << "Constructor of trie_node " <<std::endl;
	*children = NULL;
      /*  *children = new trie_node[26];
        for(int i =0; i<26;i++)
        {
            children[i] = NULL;
        }*/
        is_a_leaf = 0;
    }
    ~trie_node()
    {
        delete[] children;
    }
	void initialize()
	{
		//std::cout << "initializing the children " <<std::endl;
		*children = new trie_node[26];
		for(int i =0; i<26;i++)
		{
			children[i] = NULL;
		}
	}
};
class trie
{
        int count;
        trie_node * root;
        public:
        trie():root(new trie_node())
        {
//		std::cout << "constructor of trie " <<std::endl;
		root->initialize();
        }
        ~trie()
        {
            delete root;
        }
        void insert(trie* t, char key[], int len)
        {
		std::cout << "Inserting string " <<key<<std::endl;
            trie_node* current = root;
            for (int i =0;i<len;i++)
            {
                int index = (int)key[i] - (int)'a';
		std::cout << "Index is " << index <<std::endl;
                if(current->children[index] ==NULL)
                {
		//	std::cout << "Inside " <<std::endl;
                    current->children[index] = new trie_node();
			current->children[index]->initialize();
			current->c = key[i];
                 }
                current = current->children[index];
            }
            current->is_a_leaf = 1; 
        }
        int search(trie* t, char key[], int len)
        {
            trie_node * current = root;
            for (int i =0;i<len;i++)
            {
                int index = (int)key[i] - (int)'a';
                if(current->children[index] != NULL)
                {
                    current = current->children[index];
                }
		else
		{
			std::cout << "Breaking while searching for index " <<index<<std::endl;
			//break;
			return 0;
		}
            }
            if ((current->is_a_leaf == 1) && (current  != NULL))
		 		return 1;
           }
};
int main()
{
	std::cout << "Inside main() " <<std::endl;
    trie *t = new trie();
	std::cout << "Before insert " <<std::endl;
    t->insert(t,"deepa",5);
	t->insert(t,"anne",4);
    std::cout<<"Searching for string deepabcd " << t->search(t,"deepabcd",8)<<std::endl;
	std::cout << "Searching for string deepa " << t->search(t,"deepa",5)<<std::endl;
std::cout << "Searching for string anne " << t->search(t,"anne",4)<<std::endl;
	std::cout << "searching for string past " << t->search(t,"past",4)<<std::endl;
}
