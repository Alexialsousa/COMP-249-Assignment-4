public class CellList {


    class CellNode {

        private CellPhone cellPhone;
        private CellNode next;

        CellNode() {
            cellPhone = null;
            next = null;
        }

        CellNode(CellPhone cellPhone, CellNode next) {
            this.cellPhone = cellPhone;
            this.next = next;
        }

        CellNode(CellNode object) {
            this.cellPhone = object.cellPhone;
            this.next = object.next;
        }


    }


}
