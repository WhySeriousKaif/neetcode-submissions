class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        prefix=strs[0]
        l=len(prefix)
        n=len(strs)
        for i in range(n):
            prefix=self.findPrefix(strs[i],prefix)

            if len(prefix)==0:
                return ""
        
        return prefix

    def findPrefix(self,currStr:str,prefix:str)->str:
        currLen=len(currStr)
        prefixLen=len(prefix)
        minLen=min(currLen,prefixLen)
        idx=0
        while idx<minLen:
            if currStr[idx]!=prefix[idx]:
                break
            idx+=1
        
        return prefix[0:idx]
             

        